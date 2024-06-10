### _Chapter 11: Exceptions and Localization_

---
### `Exceptions`

**Figure 11.1** Categories of exception

![img.png](../../../../resources/img/figure-11.1.png)

Checked exception'lar handle or declare kuralına uymalıdır.
```java
// Declares
void fall(int distance) throws IOException {
    if (distance > 10) {
        throw new IOException();
    }
}

// Handles
void fall(int distance) {
    try {
        if (distance > 10) {
            throw new IOException();
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
}
```

- _Error_ program artık kurtarılamaycak kadar kötü bir hata durumu olduğunda fırlatılırlar.
- **catch** bloğu içerisinde _Throwable_ ve _Error_ yakalanabilir fakat bunun yapılması tavsiye edilmez.

**Table 11.1** Types of exceptions and errors

![img.png](../../../../resources/img/table-11.1.png)

Aşağıda ki gibi bir kod geçerlidir.
```java
var e = new RuntimeException();
throw e;
```

```java
throw RuntimeException(); // DOES NOT COMPILE
```

```java
try {
    throw new RuntimeException();
    // Unreachable
    throw new ArrayIndexOutOfBoundsException(); // DOES NOT COMPILE
} catch (Exception e) {}
```
<br/>

**Calling Methods That Throw Exceptions**

**try-catch** ile sarılan method deklerasyonunda hata fırlatılmadığı durumda.
1. Eğer catch ile yakalanan hata Exception veya RuntimeException ise kod derlenir.
2. Eğer checked exception tipinde ve Exception sınıfının alt tipinde ise derlenmez.
```java
public void good() {
    try {
        eatCarrot();
    } catch (Exception e) {
        System.out.println("Problematic");
    }
}

private void eatCarrot() {}
```

```java
public void good() {
    try {
        eatCarrot();
    } catch (Exception e) {
        System.out.println("Problematic");
    }
}

private void eatCarrot() {}
```

```java
public void bad() {
    try {
        eatCarrot();
    } catch (IOException e) { // DOES NOT COMPILE
        System.out.println("Problematic");
    }
}

private void eatCarrot() {}
```
<br/>

**Overriding Methods with Exceptions**

- Override edilen method yeni bir checked exception tanımlayamaz. _(Bkz. hop1())_
- Override edilen method daha geniş tipte bir checked exception tanımlayamaz. _(Bkz. hop2())_
- Override edilen method gövdesi eğer hata fırlatmıyorsa parent sınıfta bulunan exception'ı method deklerasyonuna eklemek
  zorunda değildir. _(Bkz. hop3())_
```java
class CanNotHopException extends Exception {}

class Hopper {
    public void hop1() {}
    public void hop2() throws CanNotHopException {}
    public void hop3() throws CanNotHopException {}
}

class Bunny extends Hopper {
    @Override
    public void hop1() throws CanNotHopException {} // DOES NOT COMPILE

    @Override
    public void hop2() throws Exception {} // DOES NOT COMPILE

    @Override
    public void hop3() {}
}
```

<br/>

**Recognizing Exception Classes**

**TABLE 11.2** Unchecked exceptions

![img.png](../../../../resources/img/table-11.2.png)