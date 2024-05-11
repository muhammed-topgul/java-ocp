### _Chapter 08: Lambdas and Functional Interfaces_

---
### `Lambda Syntax`
```java
(Animal a) -> {return a.canHoop();}
a -> a.canHop()
a -> {return a.canHop();}
(Animal a) -> a.canHop()
```

> Assingning Lambdas to _var_
>```java
>var invalid = (Animal a) -> a.canHop(); // DOES NOT COMPILE
>```
> Java lambda için tip çıkarımını bağlam üzerinden yapar. Aynı şekilde _var_ da tip çıkarımını bağlam üzerinden yapar.
> Burada ne lambda için ne de _var_ için yeterli bağlam bilgisi yok.

---
### `Functional Interface`
- _Functional Interface_ üzerinde tek bir **abstract** method bulunan **interface**'dir.

```java
@FunctionalInterface
public interface Sprint {
    public void sprint(int speed);
}
```

- _@FunctionalInterface_ anotasyonu derleyiciye bu arayüzün fonksiyonel bir arayüz olması gerektiğini bildirdiğimiz
  bir bildiridir. Bu sayede eğer arayüzde tek bir soyut method olmazsa derleme hatası oluşacaktır.
```java
@FunctionalInterface
public interface Dance { // DOES NOT COMPILE
    void move();
    void rest();
}
```
<br/><br/>

**Object Methodları**

Tüm Java sınıfları _java.lang.Object_ sınıfından belirli metholdarı kalıtır. 
 - public String toString()
 - public boolean equals(Object)
 - public int hashCode()
<br/>

Eğer _functional interface_ _Object_ sınıfında bulunan **public** methodları aynı _method signature_ ile tekrar
tanımlarsa bunlar _single abstract method_ kuralını bozmaz.
```java
public interface Dive {
    String toString();
    public abstract boolean equals(Object o);
    public abstract int hashCode();
    public void dive();
}
```

---
### `Method Reference`

```java
LearnToSpeak learner = s -> System.out.println(s);
LearnToSpeak learner = System.out::println;
```
Lambda _s_ adında bir parametre tanımlar. Ancak bu parametreyi başka bir methoda aktarmaktan başka bir şey yapmaz. 
_Method reference_ ile bu gereksiz fazlalığı yazmak zorunda kalmayız.
Method referans için 4 format vardır:
- **static** methods
- Belirli bir nesne üzerinde bulunan instance method
- Çalışma zamanında belirlenecek bir parametre üzerindeki instance methodlar
- Constructorlar

<br/>

**Calling _static_ Methods**
```java
interface Converter {
    long round(double num);
}

Converter lambda = x -> Math.round(x);
Converter methodRef = Math::round;

System.out.println(methodRef.round(100.1)); // 100
```

**Calling Instance Methods on a Particular Object**
```java
interface StringStart {
    boolean beginningCheck(String prefix);
}

var str = "Zoo";
StringStart lambda = s -> str.startsWith(s);
StringStart methodRef = str::startsWith;

System.out.println(methodRef.beginningCheck("A")); // false
```

```java
interface StringChecker {
    boolean check();
}

var str = "";

StringChecker lambda = () -> str.isEmpty();
StringChecker methodRef = str::isEmpty;

System.out.println(methodRef.check()); // true
```

Method referanslar her zaman lambda olarak çevrilebilir fakat tersi her zaman doğru değildir.
```java
var str = "";
StringChecker lambda = () -> str.startsWith("Zoo");

StringChecker methodReference = str::startsWith;        // DOES NOT COMPILE
StringChecker methodReference = str::startsWith("Zoo"); // DOES NOT COMPILE
```

**Calling Instance Methods on a Parameter**
```java
interface StringParameterChecker {
    boolean check(String prefix);
}

StringParameterChecker lambda = s -> s.isEmpty();
StringParameterChecker methodRef = String::isEmpty;

System.out.println(methodRef.check("Zoo")); // false


interface StringTwoParameterChecker {
  boolean check(String text, String prefix);
}

StringTwoParameterChecker lambda = (s, p) -> s.startsWith(p);
StringTwoParameterChecker methodRef = String::startsWith;

System.out.println(methodRef.check("Zoo", "A")); // false
```

**Calling Constructors**
```java
interface EmptyStringCreator {
    String create();
}

EmptyStringCreator lambda = () -> new String();
EmptyStringCreator methodRef = String::new;

System.out.println(methodRef.create().equals("Snake")); // false


interface StringCopier {
  String copy(String value);
}

StringCopier lambda = s -> new String(s);
StringCopier methodRef = String::new;

System.out.println(methodRef.copy("Zebra").equals("Snake")); // false
```

_**Table 8.3** Method references_

| Type                                    | Before colon           | After colon | Example         |
|:----------------------------------------|:-----------------------|:------------|:----------------|
| **static** methods                      | Class name             | Method name | Math::random    |
| Instance methods on a particular object | Instance variable name | Method name | str::startsWith |
| Instance methods on a parameter         | Class name             | Method name | String::isEmpty |
| Constructor                             | Class name             | **new**     | String::new     |


---
### `Built-in Functional Interfaces`

_**Table 8.4** Common functional interfaces_

| Functional interface | Return type | Method name  | # of parameters |
|:---------------------|:------------|:-------------|:----------------|
| Supplier<T>          | T           | get()        | 0               |
| Consumer<T>          | **void**    | accept(T)    | 1 (T)           |
| BiConsumer<T, U>     | **void**    | accept(T, U) | 2 (T, U)        |
| Predicate<T>         | **boolean** | test(T)      | 1 (T)           |
| BiPredicate<T, U>    | **boolean** | test(T, U)   | 2 (T, U)        |
| Function<T, R>       | R           | apply(T)     | 1 (T)           |
| BiFunction<T, U, R>  | R           | apply(T, U)  | 2 (T, U)        |
| UnaryOperator<T>     | T           | apply(T)     | 1 (T)           |
| BinaryOperator<T>    | T           | apply(T, T)  | 2 (T, T)        |


- **Supplier**

Input almadan değer üretir._Supplier_ arayüz tanımı aşağıda ki gibidir:
```java
@FunctionalInterface
public interface Supplier<T> {
    T get();
}
```

```java
Supplier<LocalDate> s1 = LocalDate::now;
Supplier<LocalDate> s2 = () -> LocalDate.now();

System.out.println(s1.get()); // 2024-05-11
System.out.println(s2.get()); // 2024-05-11
// $$ means that the class does not exist in a class file on the file system
System.out.println(s1);       // com.mtopgul.lambdas.Test$$Lambda$15/0x0000000800c01200@7ba4f24f
```

- **Consumer** and **BiConsumer**

Input alır fakat geriye bir değer dönmez. _BiConsumer_ ise iki tane input alır. _Consumer_ ve _BiConsumer_ arayüz tanımı 
aşağıdaki gibidir. 

```java
@FunctionalInterface
public interface Consumer<T> {
    void accept(T t);
    // omitted default method
}

@FunctionalInterface
public interface BiConsumer<T, U> {
    void accept(T t, U u);
    // omitted default method
}
```

```java
Consumer<String> c1 = System.out::println;
Consumer<String> c2 = s -> System.out.println(s);
c1.accept("Annie"); // Annie
c2.accept("Annie"); // Annie

var map = new HashMap<String, Integer>();
BiConsumer<String, Integer> b1 = map::put;
BiConsumer<String, Integer> b2 = (k, v) -> map.put(k, v);

b1.accept("chicken", 7);
b2.accept("chick", 1);
System.out.println(map); // {chicken=7, chick=1}
```

```java
var map = new HashMap<String, String>();
BiConsumer<String, String> b1 = map::put;
BiConsumer<String, String> b2 = (k, v) -> map.put(k, v);

b1.accept("chicken", "Cluck");
b2.accept("chick", "Tweep");

System.out.println(map); // {chicken=Cluck, chick=Tweep}
```

- **Predicate** and **BiPredicate**

_Predicate_ çoğunlukla filtreleme ve eşleşme işlemleri için kullanılır. _BiPredicate_ ise iki tane input alır.
_Predicate_ ve _BiPredicate_ arayüz tanımı aşağıdaki gibidir.

```java
@FunctionalInterface
public interface Predicate<T> {
    boolean test(T t);
    // omitted default and static methods
}

@FunctionalInterface
public interface BiPredicate<T, U> {
    boolean test(T t, U u);
    // omitted default methods
}
```

```java
Predicate<String> p1 = String::isEmpty;
Predicate<String> p2 = s -> s.isEmpty();

System.out.println(p1.test("")); // true
System.out.println(p2.test("")); // true

BiPredicate<String, String> b1 = String::startsWith;
BiPredicate<String, String> b2 = (s, p) -> s.startsWith(p);

System.out.println(b1.test("chicken", "chick")); // true
System.out.println(b2.test("chicken", "chick")); // true
```

- **Function** and **BiFunction**

_Function_ bir parametre ve dönüş tipi alır. Inputu dönüştürerek çıktı üretir. _BiFunction_ ise iki input ve bir dönüş tipi alır.
```java
@FunctionalInterface
public interface Function<T, R> {
    R apply(T t);
    // omitted default and static methods
}

@FunctionalInterface
public interface BiFunction<T, U, R> {
    R apply(T t, U u);
    // omitted default method
}
```

```java
Function<String, Integer> f1 = String::length;
Function<String, Integer> f2 = x -> x.length();

System.out.println(f1.apply("cluck")); // 5
System.out.println(f2.apply("cluck")); // 5


BiFunction<String, String, String> b1 = String::concat;
BiFunction<String, String, String> b2 = (s1, s2) -> s1.concat(s2);

System.out.println(b1.apply("baby ", "chick")); // baby chick
System.out.println(b2.apply("baby ", "chick")); // baby chick
```

- **UnaryOperator** and **BinaryOperator**

_UnaryOperator_ ve _BinaryOperator_ özel _Function_'lardır. Tüm tipler aynıdır. _UnaryOperator_ tek bir parametre alır 
ve aldığı tipte değer döndürür. _BinaryOperator_ ise iki aynı tipte parametre alır ve aldığı tipte değer döndürür.

```java
import java.util.function.BiFunction;
import java.util.function.Function;

@FunctionalInterface
public interface UnaryOperator<T> extends Function<T, T> {
  // omitted static method
}

@FunctionalInterface
public interface BinaryOperator<T> extends BiFunction<T, T, T> {
    // omitted static method
}

// This method signatures like this:
// T apply(T t);        // UnaryOperator
// T apply(T t1, T t2); // BinaryOperator
```

```java
UnaryOperator<String> u1 = String::toUpperCase;
UnaryOperator<String> u2 = s -> s.toUpperCase();

System.out.println(u1.apply("chirp")); // CHIRP
System.out.println(u2.apply("chirp")); // CHIRP


BinaryOperator<String> b1 = String::concat;
BinaryOperator<String> b2 = (s1, s2) -> s1.concat(s2);

System.out.println(b1.apply("baby ", "check")); // baby check
System.out.println(b2.apply("baby ", "check")); // baby check
```