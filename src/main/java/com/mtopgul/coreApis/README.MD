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
>  - Boşluk karakterlerini normalize eder. Yani _\n_ karakteri yoksa ekler ve varsa standart (_\n_) tipe çevirir. (Windows için yeni satır _\r\n_) 
```java
public String indent(int numberSpaces);
public String stripIndent();

var name = "animals";
System.out.println(name.length()); // 7
```
---