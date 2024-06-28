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
   Thread çalışıyor veya çalışmıyor olabilir. **RUNNABLE** thread çalışmaya hazır demektir. **R
4. Thread çalışmayı tamamladığında veya hata ile sonlandığında **TERMINATED** duruma geçer.