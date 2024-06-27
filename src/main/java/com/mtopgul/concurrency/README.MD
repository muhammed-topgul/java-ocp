### _Chapter 13: Concurrency_

---
### `Threads`

- Bir thread, işletim sistemi tarafından yürütülen en küçük yürütme birimidir.
- Bir process, aynı paylaşılan ortamda yürütülen bir grup ilişkili thread'den oluşur.
- Bir thread, aynı anda yanlızca bir görevi tamamlayabilir.
- Bir thread için ayrılan zaman sona erer fakat thread'in yapmış olduğu işlem tamamlanmazsa _context switch_ oluşur.
- Eğer bir thread diğer thread'lerden daha yüksek bir _thread priority_'e sahipse _interrupt_ olabilir veya başka bir 
  thread'in yerini alabilir. Java'da thread priority integer değerler ile ifade edilir.

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

- Thread execution order garanti değildir. Thread'ler genellikle rastgele sırada çalışırlar.

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

**Daemon Thread**

JVM main thread bitse bile _user-defined_ threadlerin bitmesi bekler. Uygulamayı sonlandırmaz. Fakat _daemon_ threadler 
için aynı durum söz konusu değildir. Eğer main threadin işi biterse Java daemon threadlerin tamamlanmasını beklemeden
uygulamayı sonlandırır. Örneğin _GarbageCollector_ bir daemon threaddir.

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

**Thread Life Cycle**

![img.png](../../../../resources/img/figure-13.2.png)

1. Thread başlangıçta **NEW** durumda. 
2. _start()_ methodu çağrıldığında **RUNNABLE** duruma geçer. Bu durum threadin çalıştığı anlamına gelmez. **RUNNABLE** 
   thread çalışmaya hazır demektir.
3. Thread çalışmayı tamamladığında veya hata ile sonlandığında **TERMINATED** duruma geçer.