### _Chapter 13: Concurrency_

---
### `Threads`

- Bir thread, işletim sistemi tarafından yürütülen en küçük yürütme birimidir.
- Bir process, aynı paylaşılan ortamda yürütülen bir grup ilişkili thread'den oluşur.
- Bir thread, aynı anda yanlızca bir görevi tamamlayabilir.
- Bir thread için ayrılan süre tamamlandığında fakat thread'in yapmış olduğu işlem tamamlanmazsa _context switch_ oluşur.
- _Context switch_, bir threadin mevcut durumunu saklama ve daha sonra yürütmeye devam edebilmek için geri yükleme işlemidir. 
  Bu maliyetli bir işlemdir.
- Eğer bir thread diğer thread'lerden daha yüksek bir _thread priority_'e sahipse mevcut çalışan threadi _interrupt_ 
  edebilir veya başka bir thread'in yerini alabilir. Java'da thread priority integer değerler ile ifade edilir.

**Creating a Thread**

Java'da thread oluşturabilmek için iki yol vardır:
1. Bir _Runnable_ nesne veya lambda expression Thread constructor'a verilir.
2. Thread'i **extends** eden bir sınıf oluşturulur ve _run_ methodu _override_ edilir.


```java
@FunctionalInterface 
public interface Runnable {
    void run();
}
```

- Thread çalışma sırası garanti değildir. Thread'ler genellikle rastgele sırada çalışırlar.

Aşağıda ki kodlar thread oluşturur ve çalıştırır. Sonuçları çalışana kadar belli değildir.
```java
new Thread(() -> System.out.print("Hello")).start();
System.out.print("World");
```

```java
Runnable runnable = () -> System.out.print("Hello");
new Thread(runnable).start();
System.out.print("World");
```


```java
class MyThread extends Thread {
    @Override
    public void run() {
        System.out.println("Name: " + Thread.currentThread().getName());
    }

    public static void main(String[] args) {
        new MyThread().start();
        new MyThread().start();
        new MyThread().start();
    }
}
```

> Thread'i başlatmak için _start()_ methodu kullanılır. _run()_ methodunu çağırmak thread'i başlatmaz.

> Bir Thread üzerinde _start()_ methodusadece bir kez çalıştırılabilir. İkinci kez çağrılmayı denedeğimizde 
> _IllegalThreadStateException_ hatasını alırız.
> ```java
> Thread thread = new Thread();
> thread.start();
> thread.start(); // IllegalThreadStateException
> ```

**Daemon Thread**

Daemon threadler arka planda çalışan düşük öncelikli threadlerdir.

JVM, main thread tamamlansa bile _user-defined_ threadlerin tamamlanmasını bekler. Uygulamayı sonlandırmaz. 
Fakat _daemon_ threadler için aynı durum geçerli değildir. Eğer main thread tamamlanırsa JVM daemon threadlerin 
tamamlanmasını beklemeden uygulamayı sonlandırır. 

Örneğin _GarbageCollector_ bir daemon threaddir.

```java
/*
 * Below code prints: 
 *  Main method finished!
 *  Thread finished!
 */
public static void pause() {
    try {
        Thread.sleep(1000);
    } catch (InterruptedException ignored) {
    }
    System.out.println("Thread finished!");
}

public static void main(String[] args) {
    var job = new Thread(Test::pause);
    // job.setDaemon(true);
    job.start();
    System.out.println("Main method finished!");
}
```

```java
/*
 * Below code prints: 
 *  Main method finished!
 */
public static void pause() {
    try {
        Thread.sleep(1000);
    } catch (InterruptedException ignored) {
    }
    System.out.println("Thread finished!");
}

public static void main(String[] args) {
    var job = new Thread(Test::pause);
    job.setDaemon(true);
    job.start();
    System.out.println("Main method finished!");
}
```

> setDaemon() methodu start() methodundan önce çalıştırılmalıdır. Aksi halde uygulama _IllegalThreadStateException_ fırlatır.
> ```java
> Thread thread = new Thread();
> thread.start();
> thread.setDaemon(true); // IllegalThreadStateException
> ```

**Thread Life Cycle**

![img.png](../../../../resources/img/figure-13.2.png)

1. Threadlerin 6 durumu vardır. _getState()_ methodu ile threadin durmunu öğrenebiliriz. 
2. Thread başlangıçta **NEW** durumda.
3. _start()_ methodu çağrıldığında **RUNNABLE** duruma geçer. Bu durum threadin gerçekten çalıştığı anlamına gelmez. 
   Thread çalışıyor veya çalışmıyor olabilir. **RUNNABLE** thread çalışmaya hazır demektir.
4. Thread çalışmayı tamamladığında veya hata ile sonlandığında **TERMINATED** duruma geçer.

**Polling with Sleep**

Bazen bir threadin çalışabilmesi için başka bir threadin görevini tamamlamış olması gerekir. Polling belli aralıklarla
verileri kontrol etme işlemidir.

While loop ile işlemin sonucunu kontrol etmek CPU kaynaklarını gereksi yere tükettiği için _bad practice_'dir.

```java
public static int counter = 0;
public static void main(String[] args) {
    new Thread(() -> {
        for (int i = 0; i < 100_000_000; i++) {
            counter++;
        }
    }).start();
    while (counter < 100_000_000) {
        System.out.println(counter + " Not reached yet.");
    }
    System.out.println("Reached: " + counter);
}
```

Bunun yerine _Thread.sleep()_ ile mevcut threadi durdurup diğer threadin işini tamamlamasını bekleyebiliriz.
```java
public static int counter = 0;
public static void main(String[] args) throws InterruptedException {
    new Thread(() -> {
        for (int i = 0; i < 100_000_000; i++) {
            counter++;
        }
    }).start();
    while (counter < 100_000_000) {
        System.out.println(counter + " Not reached yet.");
        Thread.sleep(1000);
    }
    System.out.println("Reached: " + counter);
}
```

**Interrupting a Thread**

Önceki çözüm CPU'un **while** döngüsünde sonsuza kadar beklemesini engellese de programa gereksiz bir sleep ekledi. 
Programın çalışması 2.1 saniye sürerse sleep yine de 1 saniye bekleyeceği için arada 0.9 saniyelik bir süre boşuna geçer.

Bunu engellemek için sonucunu beklediğimiz thread işini bitirdiğinde main threadi _interrupt_ ederek gereksiz beklemesinin
önüne geçer. 

Thread üzerinde _interrupt()_ methodunu çağırmak _TIMED_WAITING_ veya _WAITING_ durumda olan threadin tekrar _RUNNABLE_ 
duruma geçmesini sağlar. Yani _sleep()_ ile uyutulan thread için _interrupt()_ çalıştırılırsa sleep sona erer ve thread 
tekrar çalışır ve _InterruptedException_ fırlatır.

Uyumayan thread üzerinde _interrupt()_ methodunu çağırmanın hiç bir etkisi olmayacaktır. Sadece flag olarak **true** yapacaktır.

```java
public static long counter = 0;
public static void main(String[] args) {
    Thread mainThread = Thread.currentThread();
    long to = 5_000_000_000L;
    new Thread(() -> {
        for (long i = 0; i < to; i++) {
            counter++;
        }
        mainThread.interrupt();
    }).start();
    while (counter < to) {
        System.out.println(counter + " Not reached yet.");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println("Interrupted!");
        }
    }
    System.out.println("Reached: " + counter);
}
```

---
### `Concurrency API`

Java'da Concurrency API olarak adlandırılan _java.util.concurrent_ paketi bulunur. Bu paket içerisinde threadleri
oluşturmak ve yönetmek için _ExecutorService_ arayüzü bulunur.

Doğrudan threadleri kullanmak zordur. Bir tane thread için bile olsa _Concurrency API_ gibi hazır API'leri kullanmak daha iyidir.

**Single-Thread Executor**

Aşağıda ki örnekte sadece iki adet thread oluşturulur. Çıktısı kod çalışana kadar tahmin edilemez.

```java
/*
 * Below code prints:
     Begin
     Printing zoo inventory
     Printing record: 0
     Printing record: 1
     End
     Printing record: 2
     Printing zoo inventory
 */
public static void main(String[] args) {
    Runnable printInventory = () -> System.out.println("Printing zoo inventory");
    Runnable printRecords = () -> {
        for (int i = 0; i < 3; i++) {
            System.out.println("Printing record: " + i);
        }
    };
    ExecutorService service = Executors.newSingleThreadExecutor();
    try {
        System.out.println("Begin");
        service.execute(printInventory);
        service.execute(printRecords);
        service.execute(printInventory);
        System.out.println("End");
    } finally {
        service.shutdown();
    }
}
```

**Shutting Down a Thread Executor**

Thread executor ile işini bitirdiğinde mutlaka _shutdown()_ methodu çalıştırılmalıdır. Thread executor _non-daemon_ thread 
oluşturur ve _shutdown()_ çalıştırılmazsa uygulama sonlandırılmaz.

Shutdown işlemi başlatıldığında thread executor <u>hemen sonlanmaz</u>. _isShutdown()_ **true**, _isTerminated()_ **false**  
durumuna geçer. Bu aşamada;
- Yeni bir task kabul etmez ve _RejectedExecutionException_ hatasını fırlatır.
- Mevcut çalışan taskların çalışması devam eder.
- Mevcut çalışan tasklar tamamlandığında _isShutdown()_ ve _isTerminated()_ **true** olur ve thread executor sonlanır.

**Figure 13.3** ExecutorService life cycle

![img.png](../../../../resources/img/figure-13.3.png)

> _shutdown()_ methodu, thread executor'a önceden gönderilmiş taskları sonlandırmaz.

> _shutdownNow()_ methodu, thread executor'u hemen sonlandırmayı dener. Fakat sonlandırmayı garanti etmez.

**Submitting Tasks**

ExecutorService'e birden çok şekilde task gönderebiliriz. İlki _execute()_ methodu. Bu methodun dönüş tipi **void**'tir
yani değer dönmez.  Eğer değer dönmesini istediğimiz bir task göndermek istersek _submit()_ methodunu kullanabiliriz. 
Bu method bize _Future<?>_ nesnesi döner.

**Table 13.1** ExecutorService methods

![img.png](../../../../resources/img/table-13.1.png)