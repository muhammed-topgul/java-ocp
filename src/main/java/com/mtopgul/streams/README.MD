## _Chapter 10: Streams_

---
## `Returning an Optional`

### Creating an Optional

```java
public static void main(String[] args) throws Exception {
    System.out.println(average(90, 100));
    System.out.println(average());
}

public static Optional<Double> average(int... scores) {
    if (scores.length == 0) {
        return Optional.empty();
    }
    int sum = Arrays.stream(scores).sum();
    return Optional.of((double) sum / scores.length);
}
```
_Output:_
<pre>
Optional[95.0]
Optional.empty
</pre>

Önce _Optional_ değer içeriyor mu diye kontrol ettik sonra ekrana bastırdık.
```java
Optional<Double> opt = average(90, 10);
if (opt.isPresent()) {
    System.out.println(opt.get());
}
```
_Output:_
<pre>
95.0
</pre>

Eğer _Optional_'ı kontrol etmeden değeri bastırsaydık _NoSuchElementException_ hatası alabilirdik.

```java
Optional<Double> opt = average();
System.out.println(opt.get()); // NoSuchElementException
```

_Output:_
<pre style="color: red">
java.util.NoSuchElementException: No value present
</pre>

_Optional.of()_ methodu **null** değer ile çağrılırsa _NullPointerException_ fırlatır. Bunun önüne geçmek için iki çözüm 
vardır. Birincisi _if condition_ ile değerin **null** olup olmadığını kontrol etmek. İkincisi ve daha doğru olanı
_Optional.ofNullable()_ kullanmak.

```java
String value = null;

// 1. Solution
Optional<String> opt = (value == null) ? Optional.empty() : Optional.of(value);

// 2. Solution
Optional<String> opt = Optional.ofNullable(value);
```

_**Table 10.1** Common Optional instance methods_

![img.png](../../../../resources/img/table-10.1.png)

### Dealing with an Empty Optional

```java
Optional<Double> opt = average();

Double orElse = opt.orElse(0.0);
Double orElseGet = opt.orElseGet(() -> Math.random());
Double orElseThrow = opt.orElseThrow();                             // NoSuchElementException
Double orElseThrow = opt.orElseThrow(() -> new RuntimeException()); // RuntimeException
```

---
## `Using Streams`

### Understanding the Pipeline Flow

_Stream_'ler 3 parçadan oluşur. _Source_, _Intermediate operations_ ve _Terminal operations_.

_Stream_'ler _lazy evaluate_ yapıdadırlar. _Terminal operation_ çalıştırılana kadar _intermediate operations_'lar 
çalıştırılmazlar. 

_**Figure 10.2** Stream pipeline_

![img.png](../../../../resources/img/figure-10.2.png)

_**Table 10.2** Intermediate vs. terminal operations_

![img_1.png](../../../../resources/img/table-10.2.png)

### Creating Stream Sources

Java'da streamler _java.util.stream.Stream_ arayüzü tarafından temsil edilir.

#### Creating Finite Streams

```java
Stream<String> empty = Stream.empty();                    // count = 0
Stream<Integer> singleElement = Stream.of(1);          // count = 1
Stream<Integer> fromArray = Stream.of(1, 2, 3); // count = 3

var list = List.of("a", "b", "c");
Stream<String> fromList = list.stream();
```

#### Creating Infinite Streams

Sonsuz stream oluşturmak için _Stream_ üzerinde iki **static** method bulunur. _Stream.generate()_ ve _Stream.iterate()_.

```java
Stream<Double> randoms = Stream.generate(Math::random);
Stream<Integer> oddNumbers = Stream.iterate(1, n -> n + 2);
Stream<Integer> oddNumbersUnder100 = Stream.iterate(
        1,            // Seed
        n -> n < 100, // Predicate
        n -> n + 2    // UnaryOperator
);

System.out.println(randoms); // java.util.stream.ReferencePipeline$Head@34c45dca
```

_**Table 10.3** Creating a source_

![img.png](../../../../resources/img/table-10.3.png)

### Using Common Terminal Operations

---
### `Working with Primitive Streams`


---
### `Working with Advanced Stream Pipeline Concepts`