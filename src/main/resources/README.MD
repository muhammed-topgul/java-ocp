### The Final Notes

<details>
  <summary>Chapter 1: Handling Date, Time, Text, Numeric and Boolean Values</summary>

>### `Text Blocks`
>
>* _Incidental Whitespace_: Sonuca bir etkisi yoktur. Sadece kod okunabilirliğini artırmak için eklenebilir.
>* _Essential Whitespace_: Çıktıya etki eder.
>
>Text içerisinde en solda ki karakterden bir çizgi çekilir (IDE üzerinde görlebilir). Bu çizginin solunda kalan kısım
>_incidental_ sağında kalan kısım ise _essential_ whitespace olur.
>
>**Figure 1.3** Text Block
>
>![img_3.png](../resources/img/figure-1.3.png)
>
>* Text block içerisinde _\\"""_ ve _\\"\\"\\"_ aynı anlama gelir (_"""_). Ama tek başına _"""_ tanımlaması derlenemez.
>
>- **indent()** _and_ **stripIndent()**
>> **indent()** methodu;
> >- Pozitif bir sayı ile çağrılırsa, her satırın başına eşit sayıda boşluk ekler.
> >- Negatif bir sayı ile çağrılırsa, her satırın başından o sayıdaki boşluk karakterini silmeye çalışır.
> >- 0 ile çağrılırsa bir etkisi olmayacaktır.
> >- Boşluk karakterlerini normalize eder.
>     > - Satır sonu karakteri (Windows için satır sonu **_\r\n_**, Mac için satır sonu **_\n_**) var ise normalize eder. (_Normalize_: **_\n_**)
> >- Satır sonu karakteri (**_\n_**) yoksa ekler.
>
>> **stripIndent()** methodu;
> >- Başta bulunan tüm tesadüfi boşlukları siler.
> >- Satır sonu karakteri var ise normalize eder.
> >- Satır sonu karakteri yok ise <u>eklemez</u>.
>
>_**Table 4.1** Rules for indent() and stripIndent()_
>
>![img_3.png](../resources/img/table-4.1.png)

> ### `Wrapper Classes`
> 
> * _Number_ sıfını üzerinde  _byteValue()_, _shortValue()_, _intValue()_, _longValue()_, _floatValue()_, ve _doubleValue()_
>   helper methodları bulunur.
> * _Character_ sınıfı _Number_ sınıfını kalıtmaz.

> ### `String and StringBuilder`
> 
> * String sınıfı, _reverse()_ methoduna sahip değildir. StringBuilder sınıfı, _reverse()_ methoduna sahiptir.
> ```java
> String str = "12";
> str.reverse();  // DOES NOT COMPILE
> 
> StringBuilder sb = new StringBuilder("12");
> sb.reverse();   // 21
> ```
> 
> * String sınıfı, _insert()_ methoduna sahip değildir. StringBuilder sınıfı, _insert()_ methoduna sahiptir.


</details>

<details>
  <summary>Chapter 2: Controlling Program Flow</summary>

> ### `The switch Statement`
> 
> * `switch statement` tarafından desteklenen veri tipleri:
> 1. `byte` ve `Byte`
> 2. `short` ve `Short`
> 3. `char` ve `Character`
> 4. `int` ve `Integer`
> 5. `String`
> 6. `enum` değerleri
> 7. `var` (Değişken tipi yukarda ki türlerden birine çözümlenirse)
> 
> * _Acceptable Case Values_
> 1. _Literal_'ler. (3 * 5 veya "15")
> 2. _Enum_'lar.
> 3. `final constant` değişkenler. (final int bananas = 5;)
> 
> ```java
> final int getCookies() {
>     return 4;
> }
> 
> void feedAnimals() {
>     final int bananas = 1;
>     int apples = 2;
>     int numberOfAnimals = 3;
>     final int cookies = getCookies();
>     final int pears;
>     pears = 5;
>     switch (numberOfAnimals) {
>         case bananas:
>         case 3 * 5:
>         case apples:       // DOES NOT COMPILE
>         case getCookies(): // DOES NOT COMPILE
>         case cookies:      // DOES NOT COMPILE
>         case pears:        // DOES NOT COMPILE
>         case "6":          // DOES NOT COMPILE
>     }
> }
> ```
> 
> * Java da klasik `switch statement`'ler ile de değer döndürebiliriz. Aşağıda ki iki kod aynı işlemi yapar.
> ```java
> public static String getNumberName(int number) {
>     switch (number) {
>         case 1:
>             return "One";
>         case 2:
>             return "Two";
>         case 3:
>             return "Three";
>         case 4:
>             return "Four";
>         case 5:
>             return "Five";
>         default:
>             return "Unknown number";
>     }
> }
> 
> public static String getNumberName(int number) {
>     return switch (number) {
>         case 1 -> "One";
>         case 2 -> "Two";
>         case 3 -> "Three";
>         case 4 -> "Four";
>         case 5 -> "Five";
>         default -> "Unknown number";
>     };
> }
> ```

</details>

<details>
  <summary>Chapter 3: Utilizing Java ObjectOriented Approach</summary>

</details>

<details>
  <summary>Chapter 4: Handling Exceptions</summary>

</details>

<details>
  <summary>Chapter 5: Working with Arrays and Collections</summary>

</details>

<details>
  <summary>Chapter 6:Working with Streams and Lambda Expressions</summary>

</details>

<details>
  <summary>Chapter 7: Packaging and Deploying Java Code and Use the Java Platform Module System</summary>

</details>

<details>
  <summary>Chapter 8: Managing Concurrent Code Execution</summary>

</details>

<details>
  <summary>Chapter 9: Using Java I/O API</summary>

</details>

<details>
  <summary>Chapter 10: Accessing Databases Using JDBC</summary>

</details>

<details>
  <summary>Chapter 11: Implementing Localization</summary>

</details>