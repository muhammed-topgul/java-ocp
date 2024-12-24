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

```diff
! Başka bir sınıf içerisinde nesnesini oluşturabilmek için sadece 1. yöntem geçerlidir. Yani dış sınıfın nesnesine ihtiyaç vardır.
```

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
### `@Interfaces (ch03)`

Bir **interface** üzerinde hiç bir method **final** anahtar kelimesi ile işaretlenemez.