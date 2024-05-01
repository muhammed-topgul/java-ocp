### _Chapter 05: Methods_

---
#### `Java'da Overloaded Method Seçme Sıralaması`
Eskiden Java'da _autoboxing_ ve _varargs_ kavramları yoktu. Eski kodlarla uyumluluk için _autoboxing_ ve _varargs_ 
parametreli methodlar en az öncelik sıralamasına sahiptirler. Öncelik kuralları aşağıdaki gibidir.
1. Tam olarak eşlesen method
2. Daha büyük primitive tip. (Widenig yapar)
3. Autoboxed tip
4. Varargs
```java
public class Glider {
    // 1. Öncelik (Kural-1)
    public static void glide(int a) {
        System.out.println("int");
    }

    // 2. Öncelik (Kural-2)
    public static void glide(long a) {
        System.out.println("long");
    }

    // 3. Öncelik (Kural-3)
    public static void glide(Integer a) {
        System.out.println("Integer");
    }

    // 4. Öncelik (Kural-3)
    public static void glide(Object a) {
        System.out.println("Object");
    }

    // 5. Öncelik (Kural-4)
    public static void glide(int... a) {
        System.out.println("varargs");
    }

    public static void main(String[] args) {
        glide(1);
    }
}
```

---
#### `Review Quesions`
- **Q11**: Static method **null** referans üzerinden çağrılabilir. Aşağıdaki kod çalıştığında konsolda _Playing_ yazar.
```java
public class Rope {
    public static void play() {
        System.out.println("Playing");
    }

    public static void main(String[] args) {
        Rope rope = null;
        rope.play();
    }
}
```

- **Q14**: **static final** bir değişken iki şeklilde başlatılabilir;
  - i. tanımlandığı yerde.
  - ii. _**static** initializer block_ içerisinde.
```java
public class RopeSwing {
    private static final String bench;
    
    public static void main(String[] args) {
        bench = "bench";
    }
}
```

- **Q18**: Java' _pass by value_'dur. Yani methoda parametre olarak geçilen nesneyi **new** ile yeni bir değer atamak
  method bittikten sonra bir anlam ifade etmez.
```java
public class StringBuilders {
  public static StringBuilder work(StringBuilder a) {
    a = new StringBuilder("a");
    return a;
  }
  public static void main(String[] args) {
    var s1 = new StringBuilder("s1");
    var s3 = work(s1);
    System.out.println("s1 = " + s1); // s1
    System.out.println("s3 = " + s3); // a
  }
}
```