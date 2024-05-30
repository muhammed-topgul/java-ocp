### _Chapter 10: Streams_

---
### `Optionals`

**Creating an Optional**
```java
public static void main(String[] args) {
    System.out.println(average(90, 100)); // Optional[95.0]
    System.out.println(average());                  // Optional.empty

    Optional<Double> average = average(90, 100);
    if (average.isPresent()) {
    System.out.println(average.get()); // 95.0
    }

    System.out.println(average().get()); // NoSuchElementException
}

public static Optional<Double> average(int... scores) {
    if (scores.length == 0)
        return Optional.empty();
    int sum = 0;
    for (int score : scores) {
        sum += score;
    }
    return Optional.of((double) (sum / scores.length));
}
```

- **Optional.ofNullable()**

_Optional.of()_' methodu **null** değere sahip bir değişken ile çağrılırsa _NullPointerException_ fırlatır.
Bunu engellemek için _Optional.ofNullable()_ kullanılır.
```java
public static Optional<String> getValue0(String value) {
    return Optional.of(value); // NullPointerException
}

public static Optional<String> getValue1(String value) {
    return value == null ? Optional.empty() : Optional.of(value); // Optional.empty
}

public static Optional<String> getValue2(String value) {
    return Optional.ofNullable(value); // Optional.empty
}
```

**Table 10.1** Common **Optional** instance methods
![img.png](../../../../resources/img/table-10.1.png)

```java
public static void main(String[] args) {
    Optional<Double> average = average(90, 100);
    if (average.isPresent()) {
        System.out.println(average.get()); // 95.0
    }

    average.ifPresent(System.out::println); // 95.0
    average.ifPresentOrElse(System.out::println, () -> System.out.println("Empty")); // 95.0

    average = average();
    System.out.println(average.orElse(0.0)); // 0.0
    System.out.println(average.orElseGet(() -> Math.random())); // 0.52
    System.out.println(average.orElseThrow()); // NoSuchElementException
    System.out.println(average.orElseThrow(() -> new NullPointerException())); // NullPointerException
}

public static Optional<Double> average(int... scores) {
    if (scores.length == 0)
        return Optional.empty();
    int sum = 0;
    for (int score : scores) {
        sum += score;
    }
    return Optional.of((double) (sum / scores.length));
}
```

---
### `Using Streams`

_Stream_'ler 3 parçadan oluşur. _Source_, _Intermediate operations_ ve _Terminal operations_. 
Stream'ler <u>Lazy evaluate</u> yapıdadır. _Terminal operations_ çağrılana kadar _Intermediate operations_'lar çalışmaz.

Eğer bir stream tüketilmiş ise aynı streami tekrar kullanamayız.
![img.png](../../../../resources/img/figure-10.2.png)

**Table 10.2** Intermediate vs. Terminal operations
![img.png](../../../../resources/img/table-10.2.png)

**Creating Stream Sources**

Java'da streamler **java.util.stream.Stream<T>** arayüzü tarafından temsil edilir.

- **Finite Streams**
```java
Stream<String> empty = Stream.empty();
Stream<Integer> singleElement = Stream.of(1);
Stream<Integer> fromArray = Stream.of(1, 2, 3);
Stream<String> fromList = List.of("a", "b", "c").stream();

System.out.println(empty.count());         // 0
System.out.println(singleElement.count()); // 1
System.out.println(fromArray.count());     // 3
System.out.println(fromList.count());      // 3
```

- **Infinite Streams**

Sonsuz bir stream oluşturmak için _**Stream.generate()**_ ve _**Stream.iterate()**_ methodlarını kullanailiriz.
```java
Stream<Double> randoms = Stream.generate(Math::random);
randoms.forEach(System.out::println);

Stream<Integer> iterate = Stream.iterate(0, i -> i + 1);
iterate.forEach(System.out::println);

// Generates from 0 to 99
Stream<Integer> iterateUntil100 = Stream.iterate(
        0,            // seed
        i -> i < 100, // Predicate
        i -> i + 1    // UnaryOperator
);
iterateUntil100.forEach(System.out::println);
```

**Table 10.3** Creating a source
![img.png](../../../../resources/img/table-10.3.png)

**Common Terminal Operations**

**Table 10.3** Terminal stream operations
![img.png](../../../../resources/img/table-10.4.png)

&#20; **Counting**
```java
Stream<String> s = Stream.of("monkey", "gorilla", "dog");
System.out.println(s.count()); // 3
```

&#20; **min() and max()**
```java
Stream<String> s = Stream.of("monkey", "gorilla", "dog");

s.min((s1, s2) -> s1.length() - s2.length())
        .ifPresent(System.out::println); // dog

s.max(Comparator.comparingInt(String::length))
        .ifPresent(System.out::println); // gorilla

Stream<Integer> s = Stream.of(1, 2, 3);
s.min((a, b) -> a.compareTo(b))
        .ifPresent(System.out::println); // 1

s.max(Integer::compareTo)
        .ifPresent(System.out::println); // 3

```

&#20; **findAny() and findFirst()**
```java
Stream<String> s = Stream.of("monkey", "gorilla", "dog");

s.findAny().ifPresent(System.out::println);   // monkey (usually)
s.findFirst().ifPresent(System.out::println); // monkey****
```

&#20; **anyMatch(), allMatch() and noneMatch()**
```java
var list = List.of("monkey", "2", "chimp");
Stream<String> infinite = Stream.generate(() -> "chimp");
Predicate<String> pred = x -> Character.isLetter(x.charAt(0));

System.out.println(list.stream().anyMatch(pred));  // true
System.out.println(list.stream().allMatch(pred));  // false
System.out.println(list.stream().noneMatch(pred)); // false
System.out.println(infinite.anyMatch(pred));       // true
```

&#20; **forEach()**
```java
Stream<String> stream = Stream.of("monkey", "gorilla", "dog");
stream.forEach(System.out::print); // monkeygorilladog

Stream<Integer> s = Stream.of(1);
for (Integer i : s) {} // DOES NOT COMPILE
```

&#20; **reduce()**
```java
public T reduce(T identity, BinaryOperator<T> accumulator);
public Optional<T> reduce(BinaryOperator<T> accumulator);
public <U> U reduce(U identity, BiFunction<U,? super T,U> accumulator, BinaryOperator<U> combiner);
```

```java
Stream<String> stream = Stream.of("w", "o", "l", "f");
String reduce = stream.reduce("", (a, b) -> a + b);
System.out.println(reduce);    // wolf

Optional<String> opt = stream.reduce((a, b) -> a + b);
System.out.println(opt.get()); // wolf
```

Parallel stream olmadığı sürece _BinaryOperator\<U> combiner_ parametresine ait kod yürütülmez.
```java
Stream<String> stream = Stream.of("monkey", "gorilla", "dog");
Integer length = stream.reduce(0, (i, s) -> i + s.length(), (a, b) -> {
    System.out.println("Not used. Not a parallel stream!");
    return a + b;
});
System.out.println(length); // 16


Stream<String> stream = Stream.of("monkey", "gorilla", "dog");
Integer length = stream.parallel().reduce(0, (i, s) -> i + s.length(), (a, b) -> {
    System.out.println("Now used: " + a + " " + b); // Now used: 7 3    Now used: 6 10
    return a + b;
});
System.out.println(length); // 16
```

Farklı tiplerde parametreler ile işlem yapabilmek için mutlaka 3. overloaded reduce'u kullanmak gerekiyor
```java
Stream<User> users = Stream.of(new User("John", 25), new User("Julie", 35));

// int total = users.reduce(0, (i, user) -> i + user.age()); // DOES NOT COMPILE

int total = users.reduce(0, (i, user) -> i + user.age(), Integer::sum);
System.out.println(total); // 60
```

&#20; **collect()**

- Reduction'ın belirli bir tipidir.
- _Mutable reduction_ olarak adlandırılabilir.
- Normal reductiona göre daha verimlidir. Çünkü accumulating işlemi sırasında aynı mutable objeyi kullanır.
- 3 paremetreli collect() methodunun 3. parametresi sadece parallel streamlerde yürütülür.
```java
public <R,A> R collect(Collector<? super T, A,R> collector);
public <R> R collect(Supplier<R> supplier, BiConsumer<R, ? super T> accumulator, BiConsumer<R, R> combiner);
```

```java
Stream<String> stream = Stream.of("monkey", "gorilla", "dog");
// StringBuilder result = stream.collect(() -> new StringBuilder(), (a, b) -> a.append(b), (a, b) -> a.append(b));
StringBuilder result = stream.collect(StringBuilder::new, StringBuilder::append, StringBuilder::append);
System.out.println(result); // monkeygorilladog
```

```java
Stream<String> stream = Stream.of("monkey", "gorilla", "dog");

Supplier<StringBuilder> supplier = () -> new StringBuilder();
BiConsumer<StringBuilder, String> accumulator = (StringBuilder sb, String s) -> sb.append(s);
BiConsumer<StringBuilder, StringBuilder> combiner = (StringBuilder sb1, StringBuilder sb2) -> sb1.append(sb2);

StringBuilder result = stream.parallel()
                             .collect(supplier, accumulator, combiner);
System.out.println(result); // monkeygorilladog
```

```java
Stream<String> stream = Stream.of("monkey", "gorilla", "dog");
TreeSet<String> set = stream.collect(
        TreeSet::new,
        TreeSet::add, // (TreeSet<String> ts, String s) -> ts.add(s),
        TreeSet::addAll
);
System.out.println(set); // [dog, gorilla, monkey]
```

```java
public static void main(String[] args) {
    List<String> list1 = stream().collect(Collectors.toList());
    List<String> list2 = stream().toList();
    Set<String> set = stream().collect(Collectors.toSet());
    TreeSet<String> treeSet = stream().collect(Collectors.toCollection(TreeSet::new));
}

private static Stream<String> stream() {
    return Stream.of("monkey", "gorilla", "dog");
}
```

**Common Intermediate Operations**

&#20; **filter()**
```java
Stream<String> stream = Stream.of("monkey", "gorilla", "donkey");
stream.filter(s -> s.contains("e"))
        .forEach(System.out::print); // monkeydonkey

Stream<Integer> stream = Stream.iterate(0, i -> i < 10, i -> i + 1);
stream.filter(i -> i % 2 == 0)
        .forEach(System.out::print); // 02468
```