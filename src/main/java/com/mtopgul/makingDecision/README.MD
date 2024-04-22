### _Chapter 03: Making Decisions_

---
#### `if-else Statement`
- `0` ve `1` Java'da `boolean` olarak değerlendirilmez.
---

#### `Pattern Matching`
- `Pattern mathcing`, boilerplate kodları azaltmak için kullanılan yeni bir araçtır.
- `Integer` üzerinde bulunan `compareTo()` methodunu çağırmak için `cast` işlemi gerekli.
- Java 16'dan <u>önce</u> `cast` işlemi:
```java
void compareIntegers(Number number) {
  if (number instanceof Integer) {
    Integer data = (Integer) number;
    System.out.println(data.compareTo(5));
  }
}
```

- Java 16'dan <u>sonra</u> `cast` işlemi:
```java
void compareIntegers(Number number) {
  if (number instanceof Integer data) { // data `pattern variable` olarak isimlendirilir.
    System.out.println(data.compareTo(5));
  }
}
```

- **Pattern Variables and Expressions**
```java
void printIntegersGreaterThan5(Number number) {
   if(number instanceof Integer data && data.compareTo(5) > 0)
      System.out.print(data);
 }
```

**Subtypes**
- `Pattern variable`'ın tipi ifadenin sol tarafındaki değişkenin bir alt türü olmalıdır.
- Aynı tipte olamaz.
- Bu kural _traditional_ `instanceof` için geçerli <u>değildir</u>.
```java
Integer value = 123;
if(value instanceof Integer) {}
if(value instanceof Integer data) {}  // DOES NOT COMPILE
```
- Aşağıda ki örnek derlenir. Çünkü `Integer`, `Number`'ın alt tipidir.
```java
Number value = 123;
if(value instanceof Integer) {}
if(value instanceof Integer data) {}
```

**Limitations of Subtype Enforcement**
- Eğer ifadenin sol tarafı `interface` ise ifadenin sağ tarafı `final` tipte olmadığı sürece kod <u>derlenir</u>. 
  Hierarşik olarak iki sınıf birbiriyle alakasız olsa bile derlenir. 
```java
/*
 * List is an interface
 * HashMap is a class
 * Number is an abstract class
 * Integer is a final class
 */
List value = null;
if(value instanceof HashMap) {}
if(value instanceof Number data) {}
if(value instanceof Integer data) {}  // DOES NOT COMPILE
```

- Eğer ifadenin sol tarafı `non-final` bir sınıf tipinde ise (_`class` veya `abstract class`_) ve
  ifadenin sağ tarafı `interface` tipinde ise kod <u>derlenir</u>. Hierarşik olarak iki sınıf birbiriyle alakasız olsa bile derlenir.
```java
Number value = 123;
if(value instanceof List) {}
if(value instanceof ArrayList) {} // DOES NOT COMPILE
if(value instanceof List data) {}
```

**Flow Scoping**
- `Flow scoping`, değişkenin yalnızca derleyicinin türünü kesin olarak belirleyebildiği durumlarda kapsamda olduğu anlamına gelir.
```java
// number parametresi Integer'i miras almıyorsa, data değişkeni tanımsızdır
void printIntegersOrNumbersGreaterThan5(Number number) {
  if(number instanceof Integer data || data.compareTo(5) > 0) // DOES NOT COMPILE
     System.out.print(data);
}

void printIntegerTwice(Number number) {
  if (number instanceof Integer data)
      System.out.print(data.intValue());
  System.out.print(data.intValue()); // DOES NOT COMPILE
}

// COMPILES
// Methodun son satırına ulaşıldığında number parametresinin Integer'i devralması gerektiği ve
// bu nedenle if ifadesi sona erdikten sonra bile verilerin kapsamda kaldığı anlamına gelir.
void printOnlyIntegers(Number number) {
  if (!(number instanceof Integer data))
     return;
  System.out.print(data.intValue());
}
```
---


#### `The switch Statement`
- `default` opsiyoneldir ve `switch statement`'in herhangi bir yerinde olabilir.
> **Combining case Value**
> - Java 14'ten <u>önce</u> `case` values:
>```java
> switch(animal) {
>     case 1: case 2: System.out.println("Lion");
>     case 3: System.out.println("Tiger");
> }
>```
>
> - Java 14'ten <u>sonra</u> `case` values:
>```java
> switch(animal) {
>     case 1,2: System.out.println("Lion");
>     case 3: System.out.println("Tiger");
> }
> ```

- Bir `switch statement` herhangi bir `case statement` içermesi zorunlu değildir.
```java
switch(month) {} // Perfetcly valid
```

**Exiting with _break_ Statements**
```java
 // Eğer printSeason(2); çağrılısa
//  WinterSpringUnknownSummerFall yazdırır. Çünkü break; kullanılmamış.
public void printSeason(int month) {
  switch (month) {
    case 1, 2, 3:
      System.out.println("Winter");
    case 4, 5, 6:
      System.out.print("Spring");
    default:
      System.out.print("Unknown");
    case 7, 8, 9:
      System.out.print("Summer");
    case 10, 11, 12:
      System.out.print("Fall");
  }
}
```

**Selecting _switch_ Data Types**
- `switch statement` tarafından desteklenen veri tipleri:
> - `byte` ve `Byte`
> - `short` ve `Short`
> - `char` ve `Character`
> - `String`
> - `enum` values
> - `var` (tür önceki türlerden birine çözümlenirse)

- `boolean`, `long`, `float` ve `double` switch parametresi olarak kullanılamaz.
  (ayrıca `Boolean`, `Long`, `Float` ve `Double` tipleride kullanılamaz.)


**Determining Acceptable Case Values**
- Sadece `literals`, `enums` ve `final constant variables` değişkenler `case` value olarak kullanılabilir.
- `switch value` ve `case value` aynı tipte olamlıdır.
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

**The _switch_ Expression**
```java
public void printDayOfWeek(int day) {
  var result = switch (day) {
    case 0 -> "Sunday";
    case 1 -> "Monday";
    case 2 -> "Tuesday";
    case 3 -> "Wednesday";
    case 4 -> "Thursday";
    case 5 -> "Friday";
    case 6 -> "Saturday";
    default -> "Invalid value";
  }; // ; zorunlu
  System.out.print(result);
}
```

```java
// Eğer printSeason(2); çağrılısa
// Winter yazdırır.
public void printSeason(int month) {
  switch (month) {
    case 1, 2, 3 -> System.out.print("Winter");
    case 4, 5, 6 -> System.out.print("Spring");
    case 7, 8, 9 -> System.out.print("Summer");
    case 10, 11, 12 -> System.out.print("Fall");
  }
}
```

**Returning Consistent Data Types**
```java
int measurement = 10;
int size = switch (measurement) {
    case 5 -> 1;
    case 10 -> (short) 2;
    default -> 5;
    case 20 -> "3";   // DOES NOT COMPILE
    case 40 -> 4L;    // DOES NOT COMPILE
    case 50 -> null;  // DOES NOT COMPILE
};
```

**Applying a _case_ Block**
```java
int fish = 5;
int length = 12;
var name = switch (fish) {
    case 1 -> "Goldfish";
    case 2 -> {
        yield "Trout";
    }
    case 3 -> {
        if (length > 10) yield "Blobfish";
        else yield "Green";
    }
    default -> "Swordfish";
};
```

```java
int fish = 5;
int length = 12;
var name = switch (fish) {
    case 1 -> "Goldfish";
    case 2 -> {} // DOES NOT COMPILE
    case 3 -> {
        if (length > 10) yield "Blobfish";
    } // DOES NOT COMPILE
    default -> "Swordfish";
};
```
> - ; `case expression` için gerekli fakat `case blocks` ile birlikte kullanılamaz.
> ```java
> var name = switch(fish) {
>     case 1 -> "Goldfish"        // DOES NOT COMPILE (missing semicolon)
>     case 2 -> {yield "Trout";}; // DOES NOT COMPILE (extra semicolon)
> }                               // DOES NOT COMPILE (missing semicolon)
> ```

**Covering All Possible Values**
- Değer döndüren bir `switch expression` olası tüm input değerlerini işlemesi gerekir.
- Değer döndürmeyen bir `switch expression` için bu durum opsiyoneldir.
- Çözüm olarak;
- 1. `default` branch ekle.
- 2. Eğer `switch expression` `enum` alıyorsa, tüm enum değerlerini `case` branch olarak ekle.

```java
// Eğer canis 5 olursa bu kod ne yapacağını bilmiyor. Bu yüzden derlenmez.
String type = switch (canis) { // DOES NOT COMPILE
    case 1 -> "dog";
    case 2 -> "wolf";
    case 3 -> "coyote";
};
```

```java
// COMPILES
String type = switch (canis) {
    case 1 -> "dog";
    case 2 -> "wolf";
    case 3 -> "coyote";
    default -> "Invalid";
};
```

```java
// COMPILES
// Tüm Season seçenekleri tanımlandı.
// default branch gerekli değil. 
enum Season {WINTER, SPRING, SUMMER, FALL}

String getWeather(Season value) {
    return switch (value) {
      case WINTER -> "Cold";
      case SPRING -> "Rainy";
      case SUMMER -> "Hot";
      case FALL -> "Warm";
      default -> "Invalid"; // Bu örnek için derlenir fakat zorunlu değil.
    };
}
```

---

#### Working with _for_ Loops

1. Creating an Infinitive Loop
```java
for( ; ; )
    System.out.println("Hello, World");
```

2. Adding Multiple Terms to the for Statement
```java
int x = 0;
for(long y = 0, z = 4; x < 5 && y < 10; x++, y++) {
    System.out.print(y + " ");
}
System.out.print(x + " ");
```

3. Redeclaring a Variable in the Initialization Block
```java
int x = 0;
for(int x = 4; x < 5; x++) {  // DOES NOT COMPILE
    System.out.print(x + " ");  
}

for(x = 0; x < 5; x++) {     // COMPILES
    System.out.print(x + " ");  
}
```

4. Using Incompatible Data Types in the Initialization Block
```java
int x = 0;
// Başlatma bloğundaki değişkenlerin tümü aynı türde olmalıdır.
for(long y = 0, int z = 4; x < 5; x++) // DOES NOT COMPILE
    System.out.print(y + " ");

for(long y = 0, z = 4; x < 5; x++)     // COMPILES
    System.out.print(y + " ");
```

5. Using Loop Variables Outside the Loop
```java
for(long y = 0, x = 4; x < 5 && y < 10; x++, y++)
    System.out.print(y + " ");
System.out.print(x); // DOES NOT COMPILE
```

**The for-each Loop**
- for-each döngüsünü kullanabilmek için nesnenin tipi:
- 1. Built-in Java arrayleri
- 2. `java.lang.Iterable` arayüzünü `implements` eden nesneler.

```java
public void printNames(String[] names) {
  for(int counter=0; counter<names.length; counter++)
      System.out.println(names[counter]);
}

public void printNames(String[] names) {
  for(var name : names)
      System.out.println(name);
}
```


**Unreachable Code**
```java
int checkDate = 0;
while(checkDate<10) {
   checkDate++;
   if(checkDate>100) {
       break;
       checkDate++; // DOES NOT COMPILE
    }
}
```

```java
int minute = 1;
WATCH: while(minute>2) {
    if(minute++>2) {
        continue WATCH;
        System.out.print(minute); // DOES NOT COMPILE
      }
} 
```

```java
int hour = 2;
switch(hour) {
   case 1: return; hour++; // DOES NOT COMPILE
   case 2:
}
```
---

**Ek Notlar**
1. `switch` value olarak `Long` tipi kullanılamaz.
2. Flow scoping:
```java
// 43. satıra gelindiğinde guppy değişkeni zaten scope içerisinde tanımlanmış olur.
// Bu yüzden 43. satır derlenmez.
40: void getFish(Object fish) {
41:     if (!(fish instanceof String guppy))
42:         System.out.print("Eat!");
43:     else if (!(fish instanceof String guppy)) {
44:         throw new RuntimeException();
45:     }
46:     System.out.print("Swim!");
47: }
```
3. `do-while` döngdüsünde `do` için '{}' sadece çoklu satırlar için zorunludur. Aşağıda ki kod derlenir.
```java
int y = -2;
do System.out.print(++y + " ");
while(y <= 5);
```