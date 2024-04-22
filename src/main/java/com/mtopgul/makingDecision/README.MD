### _Chapter 03: Making Decisions_

---
#### `if-else Statement`
- `0` ve `1` Java'da `boolean` olarak değerlendirilmez.

---
#### `Pattern Matching`
- `Pattern mathcing`, boilerplate kodları azaltmak için kullanılar yeni bir araçtır.
- `Integer` üzerinde bulunan `compareTo()` methodunu çağırmak için `cast` işlemi gerekli.
- Java 16'dan <u>önce</u> `cast` işlemi:
>```java
>  void compareIntegers(Number number) {
>     if(number instanceof Integer) {
>        Integer data = (Integer) number;
>        System.out.println(data.compareTo(5));
>     }
>  }
>  ```

- Java 16'dan <u>sonra</u> `cast` işlemi:
>```java
> void compareIntegers(Number number) {
>   if(number instanceof Integer data) {
>      System.out.println(data.compareTo(5));
>   }
> }
>  ```
> - `data` değişkeni `pattern variable` olarak isimlendirilir.

- **Pattern Variables and Expressions**
> ```java
> void printIntegersGreaterThan5(Number number) {
>   if(number instanceof Integer data && data.compareTo(5) > 0)
>      System.out.print(data);
> }
> ```

- **Subtypes**
- `Pattern variable`'ın tipi ifadenin sol tarafındaki değişkenin bir alt türü olmalıdır.
- Aynı tipte olamaz.
- Bu kural _traditional_ `instanceof` için geçerli <u>değildir</u>.
> ```java
> Integer value = 123;
> if(value instanceof Integer) {}
> if(value instanceof Integer data) {}  // DOES NOT COMPILE
>```
- Aşağıda ki örnek derlenir. Çünkü `Integer`, `Number`'ın tipinin alt tipidir.
> ```java
> Number value = 123;
> if(value instanceof Integer) {}
> if(value instanceof Integer data) {}
>```

**Limitations of Subtype Enforcement**
- Eğer ifadenin sol tarafı `interface` ise ifadenin sağ tarafı `non-final` tipte olmadığı sürece kod <u>derlenir</u>. 
  Hierarşik olarak iki sınıf birbiriyle alakasız olsa bile derlenir. 
> ```java
> /*
>  * List is an interface
>  * HashMap is a class
>  * Number is an abstract class
>  * Integer is a final class
>  */
> List value = null;
> if(value instanceof HashMap) {}
> if(value instanceof Number data) {}
> if(value instanceof Integer data) {}  // DOES NOT COMPILE
>```

- Eğer ifadenin sol tarafı `non-final` bir sınıf tipinde ise (_`class` veya `abstract class`_) ve
  ifadenin sağ tarafı `interface` tipinde ise kod <u>derlenir</u>. Hierarşik olarak iki sınıf birbiriyle alakasız olsa bile derlenir.
>```java
> Number value = 123;
> if(value instanceof List) {}
> if(value instanceof ArrayList) {} // DOES NOT COMPILE
> if(value instanceof List data) {}
>```

**Flow Scoping**
- `Flow scoping`, değişkenin yalnızca derleyicinin türünü kesin olarak belirleyebildiği durumlarda kapsamda olduğu anlamına gelir.
>
> <u>Derlemez</u>; `number` parametresi `Integer`'ı miras almıyorsa, `data` değişkeni tanımsızdır
> ```java
> // number parametresi Integer'i miras almıyorsa, data değişkeni tanımsızdır
> void printIntegersOrNumbersGreaterThan5(Number number) {
>   if(number instanceof Integer data || data.compareTo(5) > 0) // DOES NOT COMPILE
>      System.out.print(data);
> }
> 
> void printIntegerTwice(Number number) {
>   if (number instanceof Integer data)
>       System.out.print(data.intValue());
>   System.out.print(data.intValue()); // DOES NOT COMPILE
> }
> 
> // COMPILE
> // Methodun son satırına ulaşıldığında number parametresinin Integer'i devralması gerektiği ve
> // bu nedenle if ifadesi sona erdikten sonra bile verilerin kapsamda kaldığı anlamına gelir.
> void printOnlyIntegers(Number number) {
>   if (!(number instanceof Integer data))
>      return;
>   System.out.print(data.intValue());
> }
```
