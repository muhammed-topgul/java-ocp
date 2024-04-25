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