### _Chapter 04: Core APIs_

---
#### `Creating and Manipulating Strings`
**Concatenating**
1. If both operands are numeric, + means numeric addition.
2. If either operand is a String, + means concatenation.
3. The expression is evaluated left to right.

```java
System.out.println(1 + 2);         // 3
System.out.println("a" + "b");     // ab
System.out.println("a" + "b" + 3); // ab3
System.out.println(1 + 2 + "c");   // 3c
System.out.println("c" + 1 + 2);   // c12
System.out.println("c" + null);    // cnull

var s = "1";           // s currently holds "1"
s += "2";              // s currently holds "12"
s += 3;                // s currently holds "123"
System.out.println(s); // 123
```

**Important _String_ Methods**
- **length()**
```java
public int length();

var name = "animals";
System.out.println(name.length()); // 7
```

- **charAt()**
```java
public char charAt(int index);

System.out.println(name.charAt(0)); // a
System.out.println(name.charAt(6)); // s
System.out.println(name.charAt(7)); // exception
```

- **indexOf()**
```java
public int indexOf(int ch);
public int indexOf(int ch, int fromIndex);
public int indexOf(String str);
public int indexOf(String str, int fromIndex);

var name = "animals";
System.out.println(name.indexOf('a'));     // 0
System.out.println(name.indexOf("al"));    // 4
System.out.println(name.indexOf('a', 4));  // 4
System.out.println(name.indexOf("al", 5)); // -1
```

- **substring()**
```java
public String substring(int beginIndex);
public String substring(int beginIndex, int endIndex);

var name = "animals";
System.out.println(name.substring(3));                 // mals
System.out.println(name.substring(name.indexOf('m'))); // mals
System.out.println(name.substring(3, 4));              // m
System.out.println(name.substring(3, 7));              // mals

System.out.println(name.substring(3, 3)); // empty string
System.out.println(name.substring(3, 2)); // exception
System.out.println(name.substring(3, 8)); // exception
```

- **toUpperCase()** _and_ **toUpperCase()**
```java
public String toLowerCase();
public String toUpperCase();

var name = "animals";
System.out.println(name.toUpperCase());     // ANIMALS
System.out.println("Abc123".toLowerCase()); // abc123
```

- **equals()** _and_ **equalsIgnoreCase()**
```java
public boolean equals(Object obj);
public boolean equalsIgnoreCase(String str);

System.out.println("abc".equals("ABC"));           // false
System.out.println("ABC".equals("ABC"));           // true
System.out.println("abc".equalsIgnoreCase("ABC")); // true
```

- **startsWith()**_,_ **endsWith()**  _and_ **contains()**
```java
public boolean startsWith(String prefix);
public boolean endsWith(String suffix);
public boolean contains(CharSequence charSeq);

System.out.println("abc".startsWith("a")); // true
System.out.println("abc".startsWith("A")); // false

System.out.println("abc".endsWith("c")); // true
System.out.println("abc".endsWith("a")); // false

System.out.println("abc".contains("b")); // true
System.out.println("abc".contains("B")); // false
```

- **replace()**
```java
public String replace(char oldChar, char newChar);
public String replace(CharSequence target, CharSequence replacement);

System.out.println("abcabc".replace('a', 'A'));   // AbcAbc
System.out.println("abcabc".replace("a", "A"));   // AbcAbc
System.out.println("abcabc".replace("ab", "AB")); // ABcABc
System.out.println("abcabc".replace("z", "Z"));   // abcabc
```

- **strip()** _and_ **trim()**
```java
public String strip();
public String stripLeading();
public String stripTrailing();
public String trim();

System.out.println("abc".strip());                 // abc
System.out.println("\t a b c\n".strip());          // a b c
System.out.println("\t a b c\n".strip().length()); // 5

String text = " abc\t ";
System.out.println(text.trim().length());          // 3
System.out.println(text.strip().length());         // 3
System.out.println(text.stripLeading().length());  // 5
System.out.println(text.stripTrailing().length()); // 4
```

- **indent()** _and_ **stripIndent()**
> **indent()** methodu;
>  - Pozitif bir sayı ile çağrılırsa, her satırın başına eşit sayıda boşluk ekler.
>  - Negatif bir sayı ile çağrılırsa, her satırın başından o sayıdaki boşluk karakterini silmeye çalışır.
>  - 0 ile çağrılırsa bir etkisi olmayacaktır.
>  - Boşluk karakterlerini normalize eder.
>   - Satır sonu karakteri (Windows için satır sonu **_\r\n_**, Mac için satır sonu **_\n_**) var ise normalize eder. (_Normalize_: **_\n_**)
>   - Satır sonu karakteri (**_\n_**) yoksa ekler.

> **stripIndent()** methodu;
> - Başta bulunan tüm tesadüfi boşlukları siler.
> - Satır sonu karakteri var ise normalize eder.
> - Satır sonu karakteri yok ise <u>eklemez</u>.

```java
public String indent(int numberSpaces);
public String stripIndent();

var block = """
        a
         b
        c""";

var concat = " a\n"
        + "  b\n"
        + " c";

System.out.println(block.length());                // 6
System.out.println(concat.length());               // 9
System.out.println(block.indent(1).length());      // 10
System.out.println(concat.indent(-1).length());    // 7
System.out.println(concat.indent(-4).length());    // 6
System.out.println(concat.stripIndent().length()); // 6
```
- **translateEscapes()**
```java
public String translateEscapes();

System.out.println("1\t2");           // 1	2
System.out.println("1\t2".length());  // 3
System.out.println("1\\t2");          // 1\t2
System.out.println("1\\t2".length()); // 4
        
System.out.println("1\\t2".translateEscapes()); // 1	2
```

- **isEmpty()** _and_ **isBlank()**
```java
public boolean isEmpty();
public boolean isBlank();

System.out.println(" ".isEmpty()); // false
System.out.println("".isEmpty()); // true
System.out.println(" ".isBlank()); // true
System.out.println("".isBlank()); // true
```

- **format()**
```java
public static String format(String format, Object args...);
public static String format(Locale loc, String format, Object args...);
public String formatted(Object args...);

var name = "Kate";
var orderId = 5;

// All print: Hello Kate, order 5 is ready
System.out.println("Hello " + name + ", order " + orderId + " is ready");
System.out.println(String.format("Hello %s, order %d is ready", name, orderId));
System.out.println("Hello %s, order %d is ready".formatted(name, orderId));
```
_**Table 4.2** Common formatting symbols_

| Sembol | Açıklama                                                       |
|:------:|:---------------------------------------------------------------|
| **%s** | Her tür için uygulanır ama genellikle _**String**_ değerlerine |
| **%d** | **int** ve **long** gibi tamsayi değerlerine uygulanır         |
| **%f** | **float** ve **double** gibi kayan nokta değerlerine uygulanır |
| **%n** | Satır sonu ekler                                               |

```java
var name = "James";
var score = 90.25;
var total = 100;
System.out.println("%s:%n Score: %f out of %d".formatted(name, score, total));
// James:
//  Score: 90.250000 out of 100
```

- Yanlış sembolün kullanılması çalışma zamanında hataya neden olur.
```java
System.out.println("Food: %f tons".formatted(2.0)); // Food: 2.000000 tons
System.out.println("Food: %s tons".formatted(2.0)); // Food: 2.0 tons
System.out.println("Food: %d tons".formatted(2.0)); // IllegalFormatConversionException
```

> **format() with Flags**
> - Java _%_ ile _sembol karakteri_ arasındaki isteğe bağlı _flag_'leri de destekler.
> - Varsayılan olarak **%f**, noktadan sonraki altı rakamı yazdırır.
> - Noktadan sonra bir sayı görüntülemek için **%f** yerine **%.1f** kullanılır.
> - **format()** methodu noktadan sonra sayıyı kısaltırken <u>_yuvarlama_</u> işlemi yapar.
>```java
>System.out.println("%f".formatted(90.250000));   // 90.250000
>System.out.println("%.1f".formatted(90.250000)); // 90.3
>System.out.println("%.1f".formatted(90.240000)); // 90.2
>
>var pi = 3.14159265359;
>System.out.format("[%f]",pi);     // [3.141593]
>System.out.format("[%12.8f]",pi); // [  3.14159265]
>System.out.format("[%012f]",pi);  // [00003.141593]
>System.out.format("[%12.2f]",pi); // [        3.14]
>System.out.format("[%.3f]",pi);   // [3.142]
>``` 
---
#### `Using the StringBuilder Class`
**Creating a _StringBuilder_**
```java
StringBuilder sb1 = new StringBuilder();         // Boş bir StringBuilder oluşturur.
StringBuilder sb2 = new StringBuilder("animal"); // animal içeren StringBuilder oluşturur. 
StringBuilder sb3 = new StringBuilder(10);       // Oluşturulan StringBuilder'ın kapasitesini belirtir.
```

**Important _String_ Methods**
- **_String_ ile Ortak Methodlar**
  - **substring()**, **indexOf()**, **length()** ve **charAt()**.


- **append()**
```java
public StringBuilder append(String str);

// int, char, char[] gibi parametre alan 10'dan fazla append() methodu mevcut.
var sb = new StringBuilder().append(1).append('c');
sb.append("-").append(true);
System.out.println(sb); // 1c-true
```

- **insert()**
```java
var sb = new StringBuilder("animals");
sb.insert(7, "-");  // animals-
sb.insert(0, "-");  // -animals-
sb.insert(4, "-");  // -ani-mals-
sb.insert(15, "-"); // exception
```

- **delete()** _and_ **deleteCharAt()** 
> **delete()** methodu **deleteCharAt()** methodundan daha esnektir. Eğer **delete()** methoduna _String_'in boyunu
> geçen bir parametre verilirse Java dizinin sonuna kadar siler. <u>Hata fırlatmaz</u>.
> Fakat **deleteCharAt()** methoduna _String_'in boyunu geçen bir parametre verilirse <u>hata fırlatır.</u>
```java
public StringBuilder delete(int startIndex, int endIndex);
public StringBuilder deleteCharAt(int index);

var sb = new StringBuilder("abcdefgh");
System.out.println(sb.delete(2, 4));    // abefgh
System.out.println(sb.delete(3, 30));   // abe
System.out.println(sb.deleteCharAt(1)); // ae
System.out.println(sb.deleteCharAt(3)); // exception
```

- **replace()**
```java
public StringBuilder replace(int startIndex, int endIndex, String newString);

var builder = new StringBuilder("pigeon dirty");
builder.replace(3, 6, "***");
System.out.println(builder); // pig*** dirty


var builder = new StringBuilder("pigeon dirty");
builder.replace(3, 100, "");
System.out.println(builder); // pig
```

- **reverse()**
```java
public StringBuilder reverse();
var sb = new StringBuilder("ABC");
sb.reverse();
System.out.println(sb); // CBA
```
---
#### `Understanding Arrays`
**Array Oluşturmak**
```java
int[] numbers = new int[3];
int[] moreNumbers = new int[] {42, 55, 99};
int[] moreNumbers = {42, 55, 99}; // anonymous array

// 5 tanımda geçerlidir
int[] numAnimals;
int [] numAnimals2;
int []numAnimals3;
int numAnimals4[];
int numAnimals5 [];
```

> - Çoklu "Arrays" Tanımı
>
>```java
>int[] ids, types;
>// ids ve types array tipindedir
>
>int ids[], types;
>// ids array, types int tipindedir
>``` 

**Casting**
```java
3: String[] strings = { "stringValue" };
4: Object[] objects = strings;
5: String[] againStrings = (String[]) objects;
6: againStrings[0] = new StringBuilder(); // DOES NOT COMPILE
7: objects[0] = new StringBuilder();      // Exception
```
- Satır 6 derlenmez çünkü _String[]_ dizisine sadece _String_ nesneleri eklenebilir.
- Satır 7 **ArrayStoreException** fırlatır. Dizinin referansı _Object[]_ olsa bile dizi _String[]_ tipindedir.

**Searching**
- Sıralı olmayan dizilerde sonuç belirsizdir.
```java
int[] numbers = {2,4,6,8};
System.out.println(Arrays.binarySearch(numbers, 2)); // 0
System.out.println(Arrays.binarySearch(numbers, 4)); // 1
System.out.println(Arrays.binarySearch(numbers, 1)); // -1
System.out.println(Arrays.binarySearch(numbers, 3)); // -2
System.out.println(Arrays.binarySearch(numbers, 9)); // -5

int[] numbers = new int[] {3,2,1};
System.out.println(Arrays.binarySearch(numbers, 2)); // 1
System.out.println(Arrays.binarySearch(numbers, 3)); // Belirsiz
```

**Comparing**

- **Arrays.compare()**
  - **Pozitif** bir sayı, ilk dizinin ikinciden büyük olduğu anlamına gelir.
  - **Negatif** bir sayı, ilk dizinin ikinciden daha küçük olduğu anlamına gelir.
  - **Sıfır** dizilerin aynı olduğu anlamına gelir.

Dizileri karşılaştırma kuralları;
- Her iki dizi aynı uzunlukla ve aynı elemanlara aynı sırada sahipse <u>sıfır</u> döndürür.
- Bütün elemanlar aynıysa ancak ikinci dizinin sonunda fazladan eleman varsa <u>negatif</u> sayı döndürür.
- Bütün elemanlar aynıysa ancak birinci dizinin sonunda fazladan eleman varsa <u>pozitif</u> sayı döndürür.
- İlk dizide farklı olan elaman daha küçükse <u>negatif</u> sayı döndürür.
- İlk dizide farklı olan elaman daha büyükse <u>pozitif</u> sayı döndürür.
  - **null** tüm tiplerden daha küçüktür.
  - **String**'lerde eğer birisi diğerinin <u>prefix</u>'i ise daha küçüktür.
  - Karakterler için sayılar harflerden daha küçüktür.
  - Karakterler için büyük harfler küçük harflerden küçüktür.

_**Table 4.4** Arrays.compare() examples_

| 1. Array               | 2. Array                | Sonuç     | Açıklama                                     |
|:-----------------------|:------------------------|:----------|:---------------------------------------------|
| **new int[] {1, 2}**   | **new int[] {1}**       | Pozitif   | Elemenlar aynı fakat ilk array daha uzun     |
| **new int[] {1, 2}**   | **new int[] {1, 2}**    | Sıfır     | İki array de aynı                            |
| **new String[] {"a"}** | **new String[] {"aa"}** | Negatif   | İlk eleman ikinci elemanın _substring_'i     |
| **new String[] {"a"}** | **new String[] {"A"}**  | Pozitif   | Büyük harf küçük harften küçüktür            |
| **new String[] {"a"}** | **new String[] {null}** | Pozitif   | **null** tüm tiplerden küçüktür              |
| **new String[] {1}**   | **new String[] {"a"}**  | Derlenmez | İki farklı tipte ki array karşılaştırılamaz. |

- **Arrays.mismatch()**
  - Eğer dizişer eşit ise **mismatch()** _-1_ döner. Aksi takdirde farklılığın olduğu ilk _index_'i döner.
```java
System.out.println(Arrays.mismatch(new int[]{1}, new int[]{1}));                // -1
System.out.println(Arrays.mismatch(new String[]{"a"}, new String[]{"A"}));      // 0
System.out.println(Arrays.mismatch(new int[]{1, 2}, new int[]{1}));             // 1
System.out.println(Arrays.mismatch(new int[]{1, 2, 3, 4}, new int[]{1, 2, 4})); // 2
```

Table 4.5** Equality vs. comparison vs. mismatch_

| Method         | Diziler Aynı Olduğunda | Diziler Aynı Olduğunda        |
|:---------------|:-----------------------|:------------------------------|
| **equals()**   | **true**               | **false**                     |
| **compare()**  | **0**                  | **Pozitif veya negatif sayı** |
| **mismatch()** | **-1**                 | **Sıfır veya negatif sayı**   |

---
#### `Math API`

- **min()** _and_ **max()**
> İki method da hangi parametre tipini alırsa, tip olarak onu döner.
```java
public static int min(int a, int b);
public static long min(long a, long b);
public static double min(double a, double b);
public static float min(float a, float b);

public static int max(int a, int b);
public static long max(long a, long b);
public static double max(double a, double b);
public static float max(float a, float b);
```

- **round()**
> - En yakın sayıya yuvarlar. Eğer küsürat **.5** veya büyükse yukarı, yoksa aşağı yuvarlar.
> - **double** ve **float** tipinde parametre alır. Parametre tipi **double** olursa **long**, **float** olursa **int** tipinde döner.
```java
public static long round(double num);
public static int round(float num);

long low = Math.round(123.45);       // 123
long high = Math.round(123.50);      // 124
int fromFloat = Math.round(123.45f); // 123
```

- **ceil()** _and_ **floor()**
```java
public static double ceil(double num);
public static double floor(double num);

double c = Math.ceil(3.14);  // 4.0
double f = Math.floor(3.14); // 3.0 
```
- **pow()**
```java
public static double pow(double number, double exponent);

double squared = Math.pow(5, 2); // 25.0
```

---
#### `Dates and Times`
**Creating Dates and Times**
- **now()**
```java
System.out.println(LocalDate.now());       // 2024-04-28
System.out.println(LocalTime.now());       // 22:58:16.891992500
System.out.println(LocalDateTime.now());   // 2024-04-28T22:58:16.891992500
System.out.println(ZonedDateTime.now());   // 2024-04-28T22:58:16.892992300+03:00[Europe/Istanbul]
System.out.println(OffsetDateTime.now());  // 2024-04-28T22:58:16.892992300+03:00
```

- **of()**

**LocalDate.of()**
```java
public static LocalDate of(int year, int month, int dayOfMonth);
public static LocalDate of(int year, Month month, int dayOfMonth);

LocalDate date1 = LocalDate.of(2024, 4, 28);
LocalDate date2 = LocalDate.of(2024, Month.APRIL, 28);
        
System.out.println(date1); // 2024-04-28
System.out.println(date2); // 2024-04-28
```

**LocalTime.of()**
```java
public static LocalTime of(int hour, int minute);
public static LocalTime of(int hour, int minute, int second);
public static LocalTime of(int hour, int minute, int second, int nanos);

LocalTime time1 = LocalTime.of(23, 21);
LocalTime time2 = LocalTime.of(23, 21, 16);
LocalTime time3 = LocalTime.of(23, 21, 16, 987654321);

System.out.println(time1); // 23:21
System.out.println(time2); // 23:21:16
System.out.println(time3); // 23:21:16.987654321
```

**LocalDateTime.of()**
```java
public static LocalDateTime of(int year, int month, int dayOfMonth, int hour, int minute);
public static LocalDateTime of(int year, int month, int dayOfMonth, int hour, int minute, int second);
public static LocalDateTime of(int year, int month, int dayOfMonth, int hour, int minute, int second, int nanos);
// Others take a Month reference:
public static LocalDateTime of(int year, Month month, int dayOfMonth, int hour, int minute);
public static LocalDateTime of(int year, Month month, int dayOfMonth, int hour, int minute, int second);
public static LocalDateTime of(int year, Month month, int dayOfMonth, int hour, int minute, int second, int nanos);

// One takes an existing LocalDate and LocalTime:
public static LocalDateTime of(LocalDate date, LocalTime time);
```

**ZonedDateTime.of()**
```java
public static ZonedDateTime of(int year, int month, int dayOfMonth, int hour, int minute, int second, int nanos, ZoneId zone);
public static ZonedDateTime of(LocalDate date, LocalTime time, ZoneId zone);
public static ZonedDateTime of(LocalDateTime dateTime, ZoneId zone);

var zone = ZoneId.of("US/Eastern");
var zoned1 = ZonedDateTime.of(2022, 1, 20, 6, 15, 30, 200, zone);
var zoned2 = ZonedDateTime.of(date1, time1, zone);
var zoned3 = ZonedDateTime.of(dateTime1, zone);
```

**Manipulating Dates and Times**
- Date ve Time sınıfları <u>immutable</u>'dır.

**LocalDate.plusX()** _and_ **LocalDate.minusX()**
```java
// plus
var date = LocalDate.of(2022, Month.JANUARY, 20);
System.out.println(date);// 2022-01-20

date = date.plusDays(5);
System.out.println(date); // 2022-01-25

date = date.plusWeeks(3);
System.out.println(date); // 2022-02-15

date = date.plusMonths(2);
System.out.println(date); // 2022-04-15

date = date.plusYears(1);
System.out.println(date); // 2023-04-15

// minus
var date = LocalDate.of(2022, Month.JANUARY, 20);
System.out.println(date); // 2022-01-20

date = date.minusDays(5);
System.out.println(date); // 2022-01-15

date = date.minusWeeks(3);
System.out.println(date); // 2021-12-25

date = date.minusMonths(2);
System.out.println(date); // 2021-10-25

date = date.minusYears(1);
System.out.println(date); // 2020-10-25
```

**LocalTime.plusX()** _and_ **LocalTime.minusX()**
```java
// plus
var time = LocalTime.of(9, 12, 30, 450000000);
System.out.println(time); // 09:12:30.450

time = time.plusHours(5);
System.out.println(time); // 14:12:30.450

time = time.plusMinutes(35);
System.out.println(time); // 14:47:30.450

time = time.plusSeconds(10);
System.out.println(time); // 14:47:40.450

time = time.plusNanos(100);
System.out.println(time); // 14:47:40.450000100

// minus
var time = LocalTime.of(9, 12, 30, 450000000);
System.out.println(time); // 09:12:30.450

time = time.minusHours(5);
System.out.println(time); // 04:12:30.450

time = time.minusMinutes(35);
System.out.println(time); // 03:37:30.450

time = time.minusSeconds(10);
System.out.println(time); // 03:37:20.450

time = time.minusNanos(100);
System.out.println(time); // 03:37:20.449999900
```

**LocalDateTime.plusX()** _and_ **LocalDateTime.minusX()**
```java
var date = LocalDate.of(2024, Month.JANUARY, 20);
var time = LocalTime.of(5, 15);
var dateTime = LocalDateTime.of(date, time);
System.out.println(dateTime); // 2024-01-20T05:15

dateTime = dateTime.plusYears(5);
System.out.println(dateTime); // 2029-01-20T05:15

dateTime = dateTime.minusDays(2);
System.out.println(dateTime); // 2029-01-18T05:15

dateTime = dateTime.plusHours(15);
System.out.println(dateTime); // 2029-01-18T20:15

dateTime = dateTime.minusNanos(500000000);
System.out.println(dateTime); // 2029-01-18T20:14:59.500

LocalDateTime dateTime = LocalDateTime.of(date, time)
        .minusDays(1)
        .minusHours(10)
        .plusSeconds(30);
System.out.println(dateTime); // 2024-01-18T19:15:30
```

```java
// LocalDate sınıfı immutable'dır
var date = LocalDate.of(2024, Month.JANUARY, 20);
date.plusDays(10);
System.out.println(date); // 2024-01-20


// Derlenmez
// LocalDate sınıfı üzerinden sadece; YIL, AY ve GÜN manipulasyonları yapılabilir
var date = LocalDate.of(2024, Month.JANUARY, 20);
date = date.plusMinutes(1); // DOES NOT COMPILE
```

**Periods**
> Java'da YIL, AY, GÜN ve HAFTA zaman dilimleri oluşturabilmek için kullanılan yardımcı sınıftır.
> 
> Aşağıdaki örnekte _Period_ kullanmasaydık _performAnimalEnrichment_ methodunun reusable olmasını engellemiş olurduk.
>
> Örneğin ay yerine hafta, gün veya yıl eklemek istersek her seferinde o methodu yeniden yazmanız gerekirdi.
> 
> Bknz: performAnimalEnrichmentV1(). Her bir zaman için yeniden yazılması gerekiyor.

```java
public static void main(String[] args) {
    var start = LocalDate.of(2022, Month.JANUARY, 1);
    var end = LocalDate.of(2022, 3, 30);
    Period period = Period.ofMonths(3);
    performAnimalEnrichment(start, end, period);
}

private static void performAnimalEnrichment(LocalDate start, LocalDate end, Period period) {
    var upto = start;
    while (upto.isBefore(end)) {
        System.out.println("Give new toy: " + upto);
        upto = upto.plus(period); // add a month
        // period yerine plusMonth(1) ile ekleme yapsaydık performAnimalEnrichment methodu
        // reusable olmayacaktı. Period ile bu methodu faklı şekilde çalıştırabiliriz.
        // Period.ofYears(3), Period.ofMonths(3), Period.ofWeeks(3) ve Period.ofDays(3)
    }
}

private static void performAnimalEnrichmentV1(LocalDate start, LocalDate end) {
  var upto = start;
  while (upto.isBefore(end)) {
    System.out.println("give new toy: " + upto);
    upto = upto.plusMonths(1); // add a month
  }
}
```

**Period** Oluşturmak
>-  _Period_ çıktısı _P_ ile başlar.
>- _Period_, _LocalTime_ ile birlikte kullanılamz.
>- _Period_ gün ve daha büyük zaman dilimleri için kullanılabilir.
>- _Period_ ile GÜN, HAFTA, AY ve YIL zaman dilimi oluşturulabilir. 
```java
Period annually = Period.ofYears(1);          // P1Y
Period quarterly = Period.ofMonths(3);        // P3M
Period everyThreeWeeks = Period.ofWeeks(3);   // P21D
Period everyOtherDay = Period.ofDays(2);      // P2D
Period everyYearAndWeek = Period.of(1, 0, 7); // P1Y7D

Period period = Period.of(2, 3, 5); // P2Y3M5D
```

> _Period_ oluştururken method chain yapılamaz. Çünkü oluşturma methodları **static**'tir.
> 
> Aşağıdaki kod parçaları aynıdır. İkiside 1 haftalık period oluşturur.
```java
var wrong = Period.ofYears(1).ofWeeks(1); // every week

var wrong = Period.ofYears(1);
wrong = Period.ofWeeks(1);
```

```java
var date = LocalDate.of(2022, 1, 20);
var time = LocalTime.of(6, 15);
var dateTime = LocalDateTime.of(date, time);
var period = Period.ofMonths(1);

System.out.println(date.plus(period));     // 2022-02-20
System.out.println(dateTime.plus(period)); // 2022-02-20T06:15
System.out.println(time.plus(period));     // Exceptio
```

**Duration** Oluşturmak
>- _Duration_ çıktısı _PT_ ile başlar. Period of Time.
>- _Duration_ SAAT, DAKİKA ve SANİYE zaman dilimi oluşturulabilir.
>- _Duration_ için doğrudan _of()_ factory methodu yok. Eğer 1 saat 30 dk demek istiyorsanız 90 dakika olarak tanımlamalısınız.
```java
Duration daily = Duration.ofDays(1);                // PT24H
Duration hourly = Duration.ofHours(1);              // PT1H
Duration everyMinute = Duration.ofMinutes(1);       // PT1M
Duration everyTenSeconds = Duration.ofSeconds(10);  // PT10S
Duration everyMilli = Duration.ofMillis(1);         // PT0.001S
Duration everyNano = Duration.ofNanos(1);           // PT0.000000001S
```

>- Yukardaki örneği _ChronoUnit_ ile yeniden yazalım.
```java
var daily = Duration.of(1, ChronoUnit.DAYS);
var hourly = Duration.of(1, ChronoUnit.HOURS);
var everyMinute = Duration.of(1, ChronoUnit.MINUTES);
var everyTenSeconds = Duration.of(10, ChronoUnit.SECONDS);
var everyMilli = Duration.of(1, ChronoUnit.MILLIS);
var everyNano = Duration.of(1, ChronoUnit.NANOS);
```