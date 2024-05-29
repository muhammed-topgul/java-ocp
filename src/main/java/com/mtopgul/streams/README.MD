### _Chapter 10: Streams_

---
### `Common Collection APIs`

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
