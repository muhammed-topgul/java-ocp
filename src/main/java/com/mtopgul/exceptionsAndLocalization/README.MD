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

**TABLE 11.3** Checked exceptions

![img.png](../../../../resources/img/table-11.3.png)

**TABLE 11.4** Errors

- Error'lar unchecked'dir.
- JVM tarafından fırlatılırlar.
- Handle or declare kuralına uymak zorunda değildirler.

![img.png](../../../../resources/img/table-11.4.png)

**Handling Exceptions**

---
### `Handling Exception`

**Multi-Catch Block**
```java
try {
    System.out.println(Integer.parseInt(args[1]));
} catch (ArrayIndexOutOfBoundsException e) {
    System.out.println("Missing or invalid input.");
} catch (NumberFormatException e) {
    System.out.println("Missing or invalid input.");
}

try {
    System.out.println(Integer.parseInt(args[1]));
} catch (ArrayIndexOutOfBoundsException | NumberFormatException e) {
    System.out.println("Missing or invalid input.");
}
```

```java
catch(Exception1 e | Exception2 e | Exception3 e)    // DOES NOT COMPILE
catch(Exception1 e1 | Exception2 e2 | Exception3 e3) // DOES NOT COMPILE
catch(Exception1 | Exception2 | Exception3 e)
```

Multi-catch içerisinde hierarşik olarak birbirinden bağımsız exception sınıflarını kullanmamız gerekiyor.

```java
try {
    throw new IOException();
} catch (FileNotFoundException | IOException e) {} // DOES NOT COMPILE
```

```java
try {
    throw new IOException();
} catch (Exception | IOException e) {} // DOES NOT COMPILE
```

**Finally Block**

- Exception olsun veya olmasın **finally** block çalışır.
- Finally ile birlikte, unchecked exceptionlar için **catch** block kullanmak opsiyoneldir.
- Finally block en sonda olması gerekiyor.
- Finally block her zaman çalışır fakat her zaman tamamlanacağının garantisi yoktur. Eğer finally block içerisinde hata 
  olursa kod yine hata üretir.
```java
/*
  Below code prints:
   Inside catch block
   Inside finally block      
 */
public static void main(String[] args) {
    try {
        fall();
        System.out.println("Inside try block");
    } catch (UnsupportedOperationException e) {
        System.out.println("Inside catch block");
    } finally {
        System.out.println("Inside finally block");
    }
}

private static void fall() {
    throw new UnsupportedOperationException();
}
```

```java
/*
  Below code prints:
   Inside finally block
   Exception in thread "main" java.lang.UnsupportedOperationException     
 */
public static void main(String[] args) {
    try {
        fall();
        System.out.println("Inside try block");
    } finally {
        System.out.println("Inside finally block");
    }
}

private static void fall() {
    throw new UnsupportedOperationException();
}
```

```java
/*
  Below code prints:
   Inside try block
   Inside finally block
   3       
 */
public static void main(String[] args) {
    System.out.println(goHome());
}

private static int goHome() {
    try {
        System.out.println("Inside try block");
        return 1;
    } catch (Exception e) {
        System.out.println("Inside catch block");
        return 2;
    } finally {
        System.out.println("Inside finally block");
        return 3;
    }
}
```

```java
/*
  Below code prints:
   Inside try block
   Inside finally block
   1       
 */
public static void main(String[] args) {
    System.out.println(goHome());
}

private static int goHome() {
    try {
        System.out.println("Inside try block");
        return 1;
    } catch (Exception e) {
        System.out.println("Inside catch block");
        return 2;
    } finally {
        System.out.println("Inside finally block");
    }
}
```

```java
/*
  Below code prints:
   Inside try block
   Exception in thread "main" java.lang.NullPointerException      
 */
String text = null;
try {
    System.out.println("Inside try block");
} catch (Exception e) {
    System.out.println("Inside catch block");
} finally {
    System.out.println(text.toUpperCase()); // Causes to exception
    System.out.println("Inside finally block");
}
```

Eğer try içerisinde _System.exit(0)_ çalıştırılırsa Java uygulaması aniden durur ve **finally** block hiç çalışmaz.
```java
try {
    System.exit(0);
}  finally {
    System.out.println("Never going to here"); // Will not print
}
```

---
### `Automating Resource Management`

Veri tabanı veya dosya işlemleri gibi harici kaynaklara resource denir. Bunlar üzerinde işlem yapabilmek için uygulama
üzerinde _connection_ açılması gerekir. Eğer bu bağlantılar kapatılmazsa _memory leak_'lere neden olur.

```java
FileInputStream fis = null;
try {
    fis = new FileInputStream("myFile.txt");
} catch (IOException e) {
    e.printStackTrace();
} finally {
    if (fis != null) {
        try {
            fis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
```

**Try with Resources**

Yukarıda ki kodda manuel bir şekilde resouce kapatıldı. Ama Java'da resouce kapatma işlemi otomatik olarak da yapılabilir.

```java
try(FileInputStream fis = new FileInputStream("myFile.txt")) {
    // Read the file
} catch (IOException e) {
    e.printStackTrace();
}
```

- Bir sınıfın try with resouce ile kullanılabilmesi için _Closable_ doğal olarak onun parenti olan _AutoClosable_ 
  arayüzünü implement etmesi gerekir.
- _Closable_ ve _AutoClosable_ farkı, close() methodunun fırlattığı exception tipidir.
  ```java
  public interface AutoCloseable {
    void close() throws Exception;
  }
  ```
  ```java
  public interface Closeable extends AutoCloseable {
    public void close() throws IOException;
  }
  ```
- close() methodu eğer checked exception fırlatıyorsa exception **catch** block içerisinde mutlaka yakalanmalıdır.
- Derleyici arka planda bizim yerimize **finally** bloğu ekleyecektir.
```java
class HugeResource implements AutoCloseable {
    private final String fileName;

    HugeResource(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void close() throws Exception {
        System.out.println("Resource closed.");
    }

    public static void main(String[] args) {
        try (var resource = new HugeResource("myFile.txt")) {
            // Read the file
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
```