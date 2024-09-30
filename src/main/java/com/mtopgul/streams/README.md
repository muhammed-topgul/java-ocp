### _Chapter 10: Streams_

---
### `Returning an Optioanl`

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

---
### `Using Streams`


---
### `Working with Primitive Streams`


---
### `Working with Advanced Stream Pipeline Concepts`