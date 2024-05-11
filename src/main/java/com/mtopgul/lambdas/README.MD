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