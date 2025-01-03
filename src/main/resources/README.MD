### The Final Notes
---
### `@Text Blocks (ch01)`

* _Incidental Whitespace_: Sonuca bir etkisi yoktur. Sadece kod okunabilirliğini artırmak için eklenebilir.
* _Essential Whitespace_: Çıktıya etki eder.

Text içerisinde en solda ki karakterden bir çizgi çekilir (IDE üzerinde görlebilir). Bu çizginin solunda kalan kısım
_incidental_ sağında kalan kısım ise _essential_ whitespace olur.

**Figure 1.3** Text Block

![img_3.png](../resources/img/figure-1.3.png)

* Text block içerisinde _\\"""_ ve _\\"\\"\\"_ aynı anlama gelir (_"""_). Ama tek başına _"""_ tanımlaması derlenemez.

<br/><br/>

---
### `@Text Blocks (ch01)`
- **indent()** _and_ **stripIndent()**
- **indent()** methodu;
  - Pozitif bir sayı ile çağrılırsa, her satırın başına eşit sayıda boşluk ekler.
  - Negatif bir sayı ile çağrılırsa, her satırın başından o sayıdaki boşluk karakterini silmeye çalışır.
  - 0 ile çağrılırsa bir etkisi olmayacaktır.
  - Boşluk karakterlerini normalize eder.
  - Satır sonu karakteri (Windows için satır sonu **_\r\n_**, Mac için satır sonu **_\n_**) var ise normalize eder. (_Normalize_: **_\n_**)
  - Satır sonu karakteri (**_\n_**) yoksa ekler.

- **stripIndent()** methodu;
  - Başta bulunan tüm tesadüfi boşlukları siler.
  - Satır sonu karakteri var ise normalize eder.
  - Satır sonu karakteri yok ise <u>eklemez</u>.

_**Table 4.1** Rules for indent() and stripIndent()_

![img_3.png](../resources/img/table-4.1.png)

<br/><br/>

---
### `@Wrapper Classes (ch01)`

* _Number_ sıfını üzerinde  _byteValue()_, _shortValue()_, _intValue()_, _longValue()_, _floatValue()_, ve _doubleValue()_
  helper methodları bulunur.
* _Character_ sınıfı _Number_ sınıfını kalıtmaz.

<br/><br/>

---
### `@String and StringBuilder`

* String sınıfı, _reverse()_ methoduna sahip değildir. StringBuilder sınıfı, _reverse()_ methoduna sahiptir.
 ```java
 String str = "12";
 str.reverse();  // DOES NOT COMPILE
 
 StringBuilder sb = new StringBuilder("12");
 sb.reverse();   // 21
 ```

* String sınıfı, _insert()_ methoduna sahip değildir. StringBuilder sınıfı, _insert()_ methoduna sahiptir.

<br/><br/>

---
### `@The switch Statement (ch02)`

* `switch statement` tarafından desteklenen veri tipleri:
1. `byte` ve `Byte`
2. `short` ve `Short`
3. `char` ve `Character`
4. `int` ve `Integer`
5. `String`
6. `enum` değerleri
7. `var` (Değişken tipi yukarda ki türlerden birine çözümlenirse)

* _Acceptable Case Values_
1. _Literal_'ler. (3 * 5 veya "15")
2. _Enum_'lar.
3. `final constant` değişkenler. (final int bananas = 5;)

```java
final int getCookies() {
    return 4;
}

void feedAnimals() {
    final int bananas = 1;
    int apples = 2;
    int numberOfAnimals = 3;
    final int cookies = getCookies();
    final int pears;
    pears = 5;
    switch (numberOfAnimals) {
        case bananas:
        case 3 * 5:
        case apples:       // DOES NOT COMPILE
        case getCookies(): // DOES NOT COMPILE
        case cookies:      // DOES NOT COMPILE
        case pears:        // DOES NOT COMPILE
        case "6":          // DOES NOT COMPILE
    }
}
```

<br/><br/>

---
### `@The switch Statement (ch02)`
Java da klasik `switch statement`'ler ile de değer döndürebiliriz. Aşağıda ki iki kod aynı işlemi yapar.
```java
public static String getNumberName(int number) {
    switch (number) {
        case 1:
            return "One";
        case 2:
            return "Two";
        case 3:
            return "Three";
        case 4:
            return "Four";
        case 5:
            return "Five";
        default:
            return "Unknown number";
    }
}

public static String getNumberName(int number) {
    return switch (number) {
        case 1 -> "One";
        case 2 -> "Two";
        case 3 -> "Three";
        case 4 -> "Four";
        case 5 -> "Five";
        default -> "Unknown number";
    };
}
```

<br/><br/>

---
### `@Records (ch03)`

_Record_ sınıfları içerisinde _instance_ değişken ve _instance initializer block_ yazılamaz.

```java
public record Pony(String name) {
  int age;      // DOES NOT COMPILE
  { age = 10; } // DOES NOT COMPILE
}
```

<br/><br/>

---
### `@Records (ch03)`

_Record_ sınıflarında bulunan _compact constructor_ sadece validasyon ve dönüşüm için kullanılabilir. Bu constructor 
içerisinde **this** anathar kelimesi ile değişkenlere değer ataması yapılamaz.

```java
public record Panda(String name) {
    public Panda {
        this.name = name.toLowerCase(); // DOES NOT COMPILE
    }
}
```

<br/><br/>

---
### `@Records (ch03)`

_Record_ sınıflarında hem _Compact_ hem de _Long/Canonical_ constructor tanımlaması aynı anda yapılamaz.

```java
record Panda(String name) {
  public Panda(String name) { // DOES NOT COMPILE
    this.name = "TaiShan";
  }

  public Panda {              // DOES NOT COMPILE
    name = name.toLowerCase();
  }
}
```

<br/><br/>

---
### `@Records (ch03)`

_Record_ sınıflarında _Long / Canonical_ constructor tanımlaması yapılabilir.

```java
record Panda(String name) {
    public Panda(String name) {
        this.name = name;
    }
}
```

<br/><br/>

---
### `@Records (ch03)`

_Record_ sınıflarında _Non-Canonical_ constructor mutlaka _this()_ ile _Canonical_ constructor'u çağırmalı.

```java
record Panda(String name) {
  public Panda() { // DOES NOT COMPILE
    this.name = "TaiShan";
  }

  public Panda(String name) {
    this.name = name;
  }
}
```

```java
record Panda(String name) {
  public Panda() {
    this("TaiShan");
  }

  public Panda(String name) {
    this.name = name;
  }
}
```

<br/><br/>

---
### `@Inner Classes (ch03)`

_Inner_ sınıf kullanımında, eğer **static** olmayan method içerisindeysek _inner_ sınıfın nesnesini;
1. _Outer_ sınıfın nesnesi üzerinden.
2. _Outer_ sınıfın ismi üzerinden. (Aynı sınıf içerisindeyse)
3. Veya doğrudan (Aynı sınıf içerisindeyse)
oluşturabiliriz.

> Başka bir sınıf içerisinde nesnesini oluşturabilmek için sadece 1. yöntem geçerlidir. Yani dış sınıfın nesnesine ihtiyaç vardır.

```java
class Dinosaur {
  public class Pterodactyl extends Dinosaur {
  }

  public void roar() {
    var dino = new Dinosaur();
    Pterodactyl p1 = dino.new Pterodactyl();     // 1.
    Pterodactyl p2 = new Dinosaur.Pterodactyl(); // 2.
    Pterodactyl p3 = new Pterodactyl();          // 3.
  }
}

class Another {
  Dinosaur.Pterodactyl p2 = new Dinosaur(). new Pterodactyl(); // 2.
}
```

<br/><br/>

---
### `@Nested Classes (ch03)`

_Static Inner (Nested)_ sınıfa _outer_ sınıfın nesnesi üzerinden ulaşamayız.
1. _Outer_ sınıfın ismi üzerinden.
2. Veya doğrudan (Aynı sınıf içerisindeyse)
```java
class Bottle {
    public static class Ship {
    }

    public static void info() {
        var bottle = new Bottle();
        Ship s1 = bottle.new Ship(); // DOES NOT COMPILE
        Ship s2 = new Bottle.Ship(); // 1.
        Ship s3 = new Ship();        // 2.
    }
}

class Another {
  Bottle.Ship s1 = new Bottle.Ship(); // 1.
}
```

<br/><br/>

---
### `@Nested Interfaces (ch03)`

Bir sınıf içerisinde bulunan _inner interface_ tanımı implicit olarak **static**'tir.

```java
class Electricity {
    /*static*/ interface Power {}
}
```

<br/><br/>

---
### `@Interfaces (ch03)`

Bir **interface** üzerinde hiç bir method **final** anahtar kelimesi ile işaretlenemez.

<br/><br/>

---
### `@Interfaces (ch03)`

Interface'i kalıtan sınıf, _interface_ üzerinde bulunan değişkenleri _interface_ ismini belirtmeden kullanabilir. Fakat 
**static** _interface_ methodlarını _interface_ ismini belirtmeden kullanamaz.

```java
interface Ready {
   /*public static final*/ int DEFAULT_VALUE = 10;
    
    public static void info() {
        System.out.println("Default value: " + DEFAULT_VALUE);
    }
}

class GetSet implements Ready {
    static int second = DEFAULT_VALUE; // n2

    public static void main(String[] begin) {
        Ready.info();
        info(); // DOES NOT COMPILE
    }
}
```


<br/><br/>

---
### `@Overriding (ch03)`

_Override_ edilen, aynı method imzasına sahip iki methodun dönüş tipler birbirlerinin _covariant_ tipinde değilse 
kalıtan sınıf derlenmez.

```java
interface Building {
    default Double getHeight() { return 1.0; } 
}
interface Office {
    public default String getHeight() { return null; }
}
class Tower implements Building, Office { } // DOES NOT COMPILE
```

```java
class Building {
    public Double getHeight() { return 1.0; } 
}
interface Office {
    public default String getHeight() { return null; }
}
class Tower extends Building implements Office { } // DOES NOT COMPILE
```

<br/><br/>

---
### `@Overloading (ch03)`

Java'nın ilk versiyonlarında _autoboxing_ ve _varargs_ kavramları yoktu. Eski kodlarla uyumluluk için _autoboxing_ ve 
_varargs_ parametreli methodlar en az öncelik sıralamasına sahiptirler. Öncelik kuralları aşağıdaki gibidir.
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


<br/><br/>

---
### `@Lambdas (ch03)`

- Lambda içerisinde _effectively final_ olup olmamasına bakılmaksızın _instance_ ve _**static**_ değişkenler kullanılabilir.
- _Local_ değişkenlerin ve method parametrelerinin kullanılabilmesi için _effectively final_ olmaları gereklidir.

```java
interface Tasty {
     void eat();
}

class Cat {
    private static int id = 1;
    private String name = "Tom";

    public void good(String info) {
        String extraInfo = "Cat is eating";
        Tasty tasty = () -> {
            System.out.println(extraInfo);
            System.out.println(info);
            System.out.println(id);
            System.out.println(name);
        };
    }

    public void bad(String info) {
        String extraInfo = "Cat is eating";
        Tasty tasty = () -> {
            System.out.println(extraInfo); // DOES NOT COMPILE
            System.out.println(info);      // DOES NOT COMPILE
            System.out.println(id);
            System.out.println(name);
        };
        tasty.eat();

        info = "";
        extraInfo = "";
        name = "Terry";
        id = 2;
    }
}
```

<br/><br/>

---
### `@Enums (ch03)`

Tüm _enum_ constructor'ları implicit olarak **private**'dır.

```java
enum Number {
    ONE(1), TWO(2);

    private int num;

    private Number(int num) {
        this.num = num;
    }
}

enum Number {
    ONE(1), TWO(2);

    private int num;

    Number(int num) {
        this.num = num;
    }
}
```

<br/><br/>

---
### `@Enums (ch03)`

Enum içinde bulunan veya _interface_'den _override_ edilen soyut methoda mutlaka gövde yazılmalıdır. 

```java
interface Base {
    void toText();
}

enum Number implements Base {
    ONE(1) {
        @Override
        public void toText() {
            System.out.println("One");
        }

        @Override
        void printAsTurkish() {
            System.out.println("Bir");
        }
    },
    TWO(2) {
        @Override
        public void toText() {
            System.out.println("Two");
        }

        @Override
        void printAsTurkish() {
            System.out.println("İki");
        }
    };

    private int num;

    private Number(int num) {
        this.num = num;
    }

    abstract void printAsTurkish();
}
```

<br/><br/>

---
### `@Enums (ch03)`

Interface'den _override_ edilen methoda _enum_ sınıfı içerisinde gövde verilirse, her _enum_ değerinin içerisinde _override_
edilmek zorunda değildir.

```java
interface Base {
    void toText();
}

enum Number implements Base {
    ONE(1) {
    },
    TWO(2) {
        @Override
        public void toText() { // Opsiyonel override
            super.toText();
        }
    };

    private int num;

    private Number(int num) {
        this.num = num;
    }

    @Override
    public void toText() {
        System.out.println("This is " + num);
    }
}
```


<br/><br/>

---
### `@Enums (ch03)`

Her ne kadar kullanımı önerilmesede, _enum_ değerleri oluşturuldaktan sonra değiştirilebilir.

```java
class Eggs {
    enum Animal {
        CHICKEN(10), PENGUIN(50);

        private int numDays;

        private Animal(int numDays) {
            this.numDays = numDays;
        }

        public int getNumDays() {
            return numDays;
        }

        public void setNumDays(int numDays) {
            this.numDays = numDays;
        }
    }

    public static void main(String[] args) {
        Animal chicken = Animal.CHICKEN;
        System.out.println(chicken.getNumDays()); // 10

        chicken.setNumDays(20);
        System.out.println(chicken.getNumDays()); // 20
    }
}
```

<br/><br/>

---
### `@If Statements (ch03)`

Dönüş tipine sahip bir method içerisinde koşullu ifadelerin sonunda **else** yoksa, **if** statement dışında mutlaka 
değer dönüşü yapılmalıdır. Kod mutlaka **if** veya **else if** içerisine girecek bile olsa eklenmelidir.

Aşağıdaki kod içerisinde _price_ değişkenini mutlaka **if** veya **else if**' e girecek olsa bile varsayılan bir değer 
döndürülmediği için method derlenemz.
```java
private static int price = 5;
public boolean sell() {
  if (price < 10) {
      price++;
      return true;
  } else if (price >= 10) {
      return false;
  }
} // DOES NOT COMPILE
```


<br/><br/>

---
### `@Static (ch03)`

Static method içerisinde **this** kullanılamaz.

```java
int name;
private static void info() {
    this.name; // DOES NOT COMPILE
}
```


<br/><br/>

---
### `@Exceptions (ch04)`

Java da _generic exception_ sınıfı tanımlanamaz.

```java
class BadException<T> extends Exception { } // DOES NOT COMPILE
```


<br/><br/>

---
### `@Exceptions (ch04)`

**finally** block her zaman _exception_ loglarından önce basılır.

```java
try {
    System.out.print(1);
    throw new ClassCastException();
} finally {
    System.out.print(2);
}
```
``
12Exception in thread "main" java.lang.ClassCastException...
``


<br/><br/>

---
### `@Exceptions (ch04)`

**null** değere sahip _wrapper_ sınıfı _primitive_ bir tipe atadığımızda _NullPointerException_ alırız.

``
Exception in thread "main" java.lang.NullPointerException: Cannot invoke "java.lang.Integer.intValue()" because "null" is null...
``


<br/><br/>

---
### `@Exceptions (ch04)`

Catch block içerisinde bir exception fırlatılsa bile en sonda **finally** block çalışacağı için **finally** block içerisinde
fırlatılan _exception_ tüm _exception_'ları ezer. 

```java
try {
    throw new ClassCastException();
} catch (RuntimeException e) {
    throw new NullPointerException();
} finally {
    throw new RuntimeException();
}
```

``
java.lang.RuntimeException
``

<br/><br/>

---
### `@Arrays (ch05)`

Array oluşturmak.

```java
int[] numbers = new int[3];
int[] moreNumbers = new int[] {42, 55, 99};
int[] moreNumbers = {42, 55, 99}; // anonymous array

var numbers = new int[3];
var moreNumbers = new int[] {42, 55, 99};
var moreNumbers = {42, 55, 99}; // DOES NOT COMPILE
```
<br/><br/>

---
### `@Array (ch05)`

Array'lerde array uzunluğu ve değerleri aynı anda tanımlanamaz.

```java
String[] tigers = new String[1] {"tiger"}; // DOES NOT COMPILE
String ohMy [] = new String[0] {};         // DOES NOT COMPILE

String[] tigers = new String[1]; // OK
String ohMy [] = new String[0];  // OK

String[] tigers = new String[] {"tiger"};  // OK
String ohMy [] = new String[] {};          // OK
```

<br/><br/>

---
### `@Array (ch05)`

Array uzunuluğunu almak için _length_ çağrılır. _size()_ değil.

```java
public static void main(String... original) {
    System.out.println(original.length);
    System.out.println(original.size()); // DOES NOT COMPILE
}
```


<br/><br/>

---
### `@Set (ch05)`

_Set_ arayüzünde _set()_ methodu bulunmaz. Çünkü _Set_ arayüzünde sıralama ve index mevcut değildir.

```java
var chars = new HashSet<>();
chars.add('a');
chars.remove(0);
chars.set(1, 'c');  // DOES NOT COMPILE
```


<br/><br/>

---
### `@Generics (ch05)`

Generiklerde boş _<>_ ile _\<Object>_ aynı anlama gelir.

```java
var list = new ArrayList<Object>();
var list = new ArrayList<>(); // ArrayList<Object>()
```


<br/><br/>

---
### `@List (ch05)`

_Arrays.asList()_ mevcut dizinin kopyasını oluşturur. Array üzerinde veya oluşturulan dizi üzerinde yapılan elemen 
güncelleme işlemleri iki tarafta da gözlemlenebilir.

```java
Integer[] array = {1, 2, 3};

List<Integer> asList = Arrays.asList(array); // [1, 2, 3]
System.out.println(asList);

array[0] = 100;
System.out.println(asList);                  // [100, 2, 3]

asList.set(1, 200);
System.out.println(asList);                  // [100, 200, 3]
System.out.println(Arrays.toString(array));  // [100, 200, 3]
```