### The Final Notes

<details>
  <summary>Chapter 1: Building Blocks</summary>

---
### `Text Blocks`

* _Incidental Whitespace_: Sonuca bir etkisi yoktur. Sadece kod okunabilirliğini artırmak için eklenebilir.
* _Essential Whitespace_: Çıktıya etki eder.

Text içerisinde en solda ki karakterden bir çizgi çekilir (IDE üzerinde görlebilir). Bu çizginin solunda kalan kısım 
_incidental_ sağında kalan kısım ise _essential_ whitespace olur. 

**Figure 1.3** Text Block

![img_3.png](../resources/img/figure-1.3.png)

* Text block içerisinde _\\"""_ ve _\\"\\"\\"_ aynı anlama gelir (_"""_). Ama tek başına _"""_ tanımlaması derlenemez.

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

_**Table 4.1** Rules for indent() and stripIndent()_

![img_3.png](../resources/img/table-4.1.png)

---
### `Wrapper Classes`

* _Number_ sıfını üzerinde  _byteValue()_, _shortValue()_, _intValue()_, _longValue()_, _floatValue()_, ve _doubleValue()_
helper methodları bulunur.
* _Character_ sınıfı _Number_ sınıfını kalıtmaz.


</details>

<details>
  <summary>Chapter 2: Operators</summary>

</details>

<details>
  <summary>Chapter 3: Making Decisions</summary>

</details>

<details>
  <summary>Chapter 4: Core APIs</summary>

---
### `String and StringBuilder`

* String sınıfı, _reverse()_ methoduna sahip değildir. StringBuilder sınıfı, _reverse()_ methoduna sahiptir.
```java
String str = "12";
str.reverse();  // DOES NOT COMPILE

StringBuilder sb = new StringBuilder("12");
sb.reverse();   // 21
```

* String sınıfı, _insert()_ methoduna sahip değildir. StringBuilder sınıfı, _insert()_ methoduna sahiptir.

</details>

<details>
  <summary>Chapter 5: Methods</summary>

</details>

<details>
  <summary>Chapter 6: Class Design</summary>

</details>


<details>
  <summary>Chapter 7: Beyond Classes</summary>

</details>

<details>
  <summary>Chapter 8: Lambdas and Functional Interfaces</summary>

</details>


<details>
  <summary>Chapter 9: Collections and Generics</summary>

</details>

<details>
  <summary>Chapter 10: Streams</summary>

</details>


<details>
  <summary>Chapter 11: Exceptions and Localization</summary>

</details>


<details>
  <summary>Chapter 12: Modules</summary>

</details>

<details>
  <summary>Chapter 13: Concurrency</summary>

</details>


<details>
  <summary>Chapter 14: I/O</summary>

</details>


<details>
  <summary>Chapter 15: JDBC</summary>

</details>

---
#### Chapter Notes
- [Chapter 01: Building Blocks]
- [Chapter 03: Making Decisions]
- [Chapter 04: Core APIs]
- [Chapter 05: Methods]
- [Chapter 06: Class Design]
- [Chapter 07: Beyond Classes]
- [Chapter 08: Lambdas and Functional Interfaces]
- [Chapter 09: Collections and Generics]
- [Chapter 10: Streams]
- [Chapter 11: Exceptions and Localization]
- [Chapter 12: Modules]
- [Chapter 13: Concurrency]
- [Chapter 14: I/O]
- [Chapter 15: JDBC]

[Chapter 01: Building Blocks]: <https://github.com/muhammed-topgul/java-ocp/blob/master/src/main/java/com/mtopgul/buildingBlocks/README.MD>
[Chapter 03: Making Decisions]: <https://github.com/muhammed-topgul/java-ocp/blob/master/src/main/java/com/mtopgul/makingDecision/README.MD>
[Chapter 04: Core APIs]: <https://github.com/muhammed-topgul/java-ocp/blob/master/src/main/java/com/mtopgul/coreApis/README.MD>
[Chapter 05: Methods]: <https://github.com/muhammed-topgul/java-ocp/blob/master/src/main/java/com/mtopgul/methods/README.MD>
[Chapter 06: Class Design]: <https://github.com/muhammed-topgul/java-ocp/blob/master/src/main/java/com/mtopgul/classDesign/README.MD>
[Chapter 07: Beyond Classes]: <https://github.com/muhammed-topgul/java-ocp/blob/master/src/main/java/com/mtopgul/beyondClasses/README.MD>
[Chapter 08: Lambdas and Functional Interfaces]: <https://github.com/muhammed-topgul/java-ocp/blob/master/src/main/java/com/mtopgul/lambdas/README.MD>
[Chapter 09: Collections and Generics]: <https://github.com/muhammed-topgul/java-ocp/blob/master/src/main/java/com/mtopgul/collectionsAndGenerics/README.MD>
[Chapter 10: Streams]: <https://github.com/muhammed-topgul/java-ocp/blob/master/src/main/java/com/mtopgul/streams/README.MD>
[Chapter 11: Exceptions and Localization]: <https://github.com/muhammed-topgul/java-ocp/blob/master/src/main/java/com/mtopgul/exceptionsAndLocalization/README.MD>
[Chapter 12: Modules]: <https://github.com/muhammed-topgul/java-ocp/blob/master/src/main/java/com/mtopgul/modules/README.MD>
[Chapter 13: Concurrency]: <https://github.com/muhammed-topgul/java-ocp/blob/master/src/main/java/com/mtopgul/concurrency/README.MD>
[Chapter 14: I/O]: <https://github.com/muhammed-topgul/java-ocp/blob/master/src/main/java/com/mtopgul/io/README.MD>
[Chapter 15: JDBC]: <https://github.com/muhammed-topgul/java-ocp/blob/master/src/main/java/com/mtopgul/jdbc/README.MD>