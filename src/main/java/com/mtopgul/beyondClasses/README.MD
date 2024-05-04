### _Chapter 07: Beyond Classes_

---
### `Interfaces`
- _Implicit Modifiers_
1. _Interface_'ler implicit olarak **abstract**'tır.
2. _Interface_ değişkenleri implicit olarak **public**, **static** ve **final**'dır.
3. Gövdesi olmayan _Interface_ metholdarı implicit olarak **abstract**'tır.
4. **private** olmayan _Interface_ methodları implicit olarak **public**'tir.
```java
public interface Soar {
    int MAX_HEIGHT = 10;
    boolean UNDERWATER = true;
    void fly(int speed);
    void takeoff();
    double dive();

    default void move() {
        System.out.println("This is a default method");
    }

    static void ok() {
        System.out.println("This is a static method");
    }

    private void info() {
        System.out.println("This is a private method");
    }
}

// 1. Kural
public abstract interface Soar {
    // 2. Kural   
    public static final int MAX_HEIGHT = 10;
    public final static boolean UNDERWATER = true;

    // 3. Kural
    public abstract void fly(int speed);
    public abstract void takeoff();
    public abstract double dive();

    // 4. Kural
    public default void move() {
        System.out.println("This is a default method");
    }

    public static void ok() {
        System.out.println("This is a static method");
    }

    private void info() {
        System.out.println("This is a private method");
    }
}
```

---
- _**default** Interface Method Kuralları_
1. **default** methodlar sadece **interface**'ler içerisinde tanımlanabilirler.
2. **default** method **default** anahtar kelimesi ile işaretlenmeli ve method gövdesi olmalı.
3. **default** method implicit olarak **public**'tir
4. **default** method **abstract**, **final** veya **static** olarak işaretlenemezler.
5. **default** method **interface**'i uygulayan sınıf tarafından _override_ edilebilir.
6. Eğer bir sınıf aynı method imzasına sahip iki veya daha fazla **default** method'u uygularsa, kalıtan sınıf methodu
   mutlaka _override_ etmeli.

---
- _**static** Interface Methodları_
1. **static** method **static** anahtar kelimesi ile işaretlenmeli ve method gövdesi olmalıdır.
2. **static** methodun _access modifier_'ı yoksa implicit olarak **public**'tir.
3. **static** method **abstract** veya **final** olarak işaretlenemez.
   - _Not: **class** içerisinde bulunan **static** method **final** olarak işaretlenebilir._
4. **static** method miras alınamaz. Arayüzü uygulayan bir sınıfta **interface** adı olmadan erişilemez.
```java
public interface Hop {
    static int getJumpHeight() {
        return 8;
    }
}
```
- _getJumpHeight()_ methodu implicit olarak **public**'tir.

```java
public class Skip {
    public int skip() {
        return Hop.getJumpHeight();
    }
}

public class Bunny implements Hop {
    public void printDetails() {
        System.out.println(getJumpHeight()); // DOES NOT COMPILE
        System.out.println(Hop.getJumpHeight());
    }
}
```
- Interface methoduna **interface** ismi ile erişebilir. Kalıtan sınıf bile olsa **interface** ismi kullanılmalıdır.
  - _Not: **class** içerisinde bulunan **static** method kalıtan sınıf tarafından sınıf ismi belirtilmeden doğrudan 
  kullanılabilir._
  ```java
  class Skip {
    public static int skip() {
        return Hop.getJumpHeight();
    }
  }

  class Bunny extends Skip {
      public void printDetails() {
          System.out.println(skip());
      }
  }
  ```