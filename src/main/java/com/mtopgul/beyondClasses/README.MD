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

---
### `Enums`
- Her **enum** değeri _JVM_ üzerinde sadece bir kez başlatılır. Bu yüzden _equals()_ ve _==_ ile karşılaştırma yapılabilir.
- **enum** sınıfı başka bir sınıfı **extends** edemez ve hiçbir sınıf **enum** sınıfını **extends** edemez.
- **enum** sınıfı bir **interface**'i **implements** edebilir.
- Tüm **enum** _constructor_'ları implicit olarak **private**'dır.

```java
enum Season {
    WINTER, SPRING, SUMMER, FALL;
}
```

- _Enums_' lar ve _**switch** Statements_

```java
Season summer = Season.SUMMER;
var message = switch (summer) {
    case Season.WINTER -> "Get out the sled!"; // DOES NOT COMPILE
    case SUMMER -> "It is summer";
    case 0 -> "Time for the poll";             // DOES NOT COMPILE
    default -> "Is it summer yet?";
}
```

- _Enum_ sınıfının herhangi bir değeri ilk kez çağrıldığında Java tüm _enum_ değerlerini yükler. Sonraki çağrımlarda Java zaten 
  yüklenmiş olan _enum_ değerlerini döndürür.
  - _Enum_ sınıfı içerisinde _main()_ method çalıştırılırsa Java yine tüm _enum_ değerlerini yükler.
```java
enum NumberEnum {
    ONE(1),
    TWO(2),
    THREE(3);

    private NumberEnum(int number) {
        System.out.println("This is " + number);
    }
}

public class Test {
    public static void main(String[] args) {
        NumberEnum one = NumberEnum.ONE;      // This is 1
        NumberEnum two = NumberEnum.TWO;      // This is 2
        NumberEnum three = NumberEnum.THREE;  // This is 3

        NumberEnum one1 = NumberEnum.ONE;     // Hiç bir şey bastırmaz. JVM üzerinde yüklü olan mevcut enum değeri kullanılır.
        NumberEnum two1 = NumberEnum.TWO;     // Hiç bir şey bastırmaz. JVM üzerinde yüklü olan mevcut enum değeri kullanılır.
        NumberEnum three1 = NumberEnum.THREE; // Hiç bir şey bastırmaz. JVM üzerinde yüklü olan mevcut enum değeri kullanılır.
    }
}
```

- **enum** sınıfı bir **interface**'i **implements** edebilir.
- _Enum_ sınıfı içerisinde _concrete_ bir method tanımlanabilir.
- _Enum_ sınıfı içerisinde **abstract** method tanımlanabilir.
- Eğer _enum_ sınıfı içerisinde **abstract** bir method tanımlanırsa ve bir **interface**'i **implements** ederse 
  mevcut _soyut method_'ların mutlaka gövdesini yazmalıdır.
```java
public interface Weather {
    // Tüm enum değerleri bu methoda gövde vermek zorunda.
    double getAverageTemperature();
}

public enum Season implements Weather {
    WINTER(101) {
        @Override
        public String getHours() {
            return "10am-3pm";
        }

        @Override
        public String getRules() {
            return super.getRules() + " plus extra winter rules";
        }

        @Override
        public double getAverageTemperature() {
            return -12.5;
        }
    },
    SPRING(102) {
        @Override
        public String getHours() {
            return "9am-7pm";
        }

        @Override
        public double getAverageTemperature() {
            return 8.7;
        }
    },
    SUMMER(103) {
        @Override
        public String getHours() {
            return "9am-7pm";
        }

        @Override
        public double getAverageTemperature() {
            return 33.5;
        }
    },
    FALL(104) {
        @Override
        public String getHours() {
            return "9am-5pm";
        }

        @Override
        public double getAverageTemperature() {
            return 17.9;
        }
    };


    private final int code;

    Season(int code) {
        this.code = code;
    }

    // Tüm enum değerleri bu methoda gövde vermek zorunda.
    public abstract String getHours();

    // Tüm enum değerleri bu methoda gövde vermek zorunda değil.
    public String getRules() {
        return "Be careful!";
    }
}
```

```java
enum Season implements Weather {
    WINTER, SPRING, SUMMER, FALL;

    public String getHours() {
        return "9am-5pm";
    }
    
    public String getRules() {
        return "Be careful!";
    }

    public double getAverageTemperature() {
        return 30;
    }
}
```


---
### `Sealing Classes`
**_Sealed_ Sınıf Oluşturma**
  - **permits** listesinde olan her sınıf **sealed** sınıfı **extends** etmelidir.
  - **sealed** ifadesi ve **abstract** anahtar kelimesi yaygın olarak birlikte kullanılır fakat zorunlu değildir.
  - **sealed** sınıfı doğrudan kalıtan sınıflar mutlaka **final**, **sealed** veya **non-sealed** ifadelerinden
    birini mutlaka kullanmalıdır.
  - **sealed** sınıflar ile onu kalıtan _subclass_'ları aynı paket veya aynı _named module_ içerisinde olmalıdır. 
```java
public abstract sealed class Bear permits Kodiak, Panda {
}

public final class Kodiak extends Bear {
}

public non-sealed class Panda extends Bear {
}
```

**_Subclass Modifier_ Belirleme**
- **sealed** sınıfı doğrudan kalıtan sınıflar mutlaka **final**, **sealed** veya **non-sealed** ifadelerinden
birini mutlaka kullanmalıdır.


- A **final** Subclass
```java
public sealed class Antelope permits Gazelle {}

public final class Gazelle extends Antelope {}

public class George extends Gazelle {} // DOES NOT COMPILE
```

- A **sealed** Subclass
```java
public sealed class Mammal permits Equine {}

public sealed class Equine extends Mammal permits Zebra {}

public final class Zebra extends Equine {}
```

- A **non-sealed** Subclass
```java
public sealed class Wolf permits Timber {}

public non-sealed class Timber extends Wolf {}

public class MyWolf extends Timber {}

public class MyFurryWolf extends MyWolf {}
```

**Omitting the permits Clause**
- **permits** ifadesini kullanmak her zaman zorunlu değildir.
  - Eğer **sealed** sınıf ve onu kalıtan alt sınıf aynı _.java_ dosyası içerisinde ise kullanmak opsiyoneldir.
```java
public sealed class Snake /*permits Cobra*/ {}

final class Cobra extends Snake {}
```
  - **permits** ifadesi _nested_ alt sınıflar içinde opsiyoneldir.
```java
public sealed class Snake /*permits Snake.Cobra*/ {
    final class Cobra extends Snake {}
}
```
_**Table 7.3** Usage of the permits clause in sealed classes_

| Doğrudan alt sınıfların konumu         | permits ifadesi                          |
|:---------------------------------------|:-----------------------------------------|
| **sealed** sınıftan farklı bir dosyada | Zorunlu                                  |
| **sealed** sınıf ile aynı dosyada      | Kullanılabilir, ama <u>zorunlu değil</u> |
| **sealed** sınıfın nested sınıfı       | Kullanılabilir, ama <u>zorunlu değil</u> |

### `Sealing Interfaces`
```java
public sealed interface Swims permits Duck, Swan, Floats {}

public final class Duck implements Swims {}

public final class Swan implements Swims {}

// Interface permitted to extend sealed interface
public non-sealed interface Floats extends Swims {}
```
> _Note: _Interface_'ler implicit olarak **abstract**'tır. Bu yüzden **sealed interface**'i **implements** eden 
> bir **interface** sadece **sealed** ve **non-sealed** ifadeleri ile işaretlenebilir._

**Sealed Sınıf Kuralları**
1. _Sealed_ sınıf **sealed** ve **permits** ifadeleri ile birlikte tanımlanır.
2. _Sealed_ sınıflar doğrudan alt sınıflarıyla aynı pakette veya _named module_'de bildirilmelidir.
3. _Sealed_ sınıfın doğrudan alt sınıfları **final**, **sealed** veya **non-sealed** ile işaretlenmelidir.
4. _Sealed_ sınıf ile doğrudan alt sınıfları aynı dosya içerisindeyse veya alt sınıf _nested_ ise **permits** opsiyoneldir.
5. _Interface_'ler **sealed** olarak tanımlanabilirler.

---
### `Records`
```java
public record Crane() {}

public record Crane(int numberEggs, String name) {}

Crane mommy = new Crane(4, "Cammy");
System.out.println(mommy.numberEggs()); // 4 
System.out.println(mommy.name());       // Cammy
System.out.println(mommy);              // Crane[numberEggs=4, name=Cammy]
```

- **Record'lara Otomatik Eklenen Alanlar**
1. **Constructor**
2. **Access method**
3. **equals()**
4. **hashCode()**
5. **toString()**

```java
Crane mommy = new Crane(4, "Cammy");

Crane mommyCopy = new Crane(4, "Cammy");
System.out.println(mommyCopy);                                      // Crane[numberEggs=4, name=Cammy]
System.out.println(mommyCopy.equals(mommy));                        // true
System.out.println(mommyCopy.hashCode() + ", " + mommy.hashCode()); // 64874007, 64874007
```

- **record**'lar ve **record** fieldları implicit olarak **final**'dir. Yani kalıtılamazlar.
```java
public record BlueCrane() extends Crane {} // DOES NOT COMPILE
```

- **record**'lar başka bir sınıfı kalıtamaz.
```java
public class Dobby {}

public record BlueCrane() extends Dobby {} // DOES NOT COMPILE
```

- **record**'lar başka bir **interface**'i **implements** edebilirler.
```java
public interface Bird {}

public record Crane(int numberEggs, String name) implements Bird {}
```
**Constructor Oluşturma**
- Long (Canonical) Constructor
  - Tüm fieldlar implicit olarak **final**'dır. Bu yüzden tün fieldlara değer atanmalıdır.
```java
public record Crane(int numberEggs, String name) {
    // Long or Canonical constructor
    public Crane(int numberEggs, String name) {
        this.numberEggs = numberEggs;
        this.name = name;
    }
}

public record Crane(int numberEggs, String name) {
    public Crane(int numberEggs, String name) {} // DOES NOT COMPILE
}
```