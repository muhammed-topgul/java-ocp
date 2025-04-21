### _Modules_

---
### `Creating and Running a Modular Program`

**Figure 12.3** Contents of `zoo.animal.feeding`

![figure-12.3.png](..%2F..%2F..%2F..%2Fresources%2Fimg%2Ffigure-12.3.png)

**Figure 12.4** Module `zoo.animal.feeding` directory structure

![figure-12.4.png](..%2F..%2F..%2F..%2Fresources%2Fimg%2Ffigure-12.4.png)

### Compiling Our First Module

Bir modulu derlemek için:

- `javac --module-path mods -d target feeding/zoo/animal/feeding/Task.java feeding/module-info.java`
- `javac -p mods -d target feeding/zoo/animal/feeding/*.java feeding/*.java`

> **Abbreviations**
> - `-d` derlenen dosyaların yerleştirileceği hedef dizini belirtir.
> - `--module-path` ve `-p` aynı anlama gelir.
> - `--module` ve `-m` aynı anlama gelir.

**Figure 12.5** Running a module using _java_

![figure-12.5.png](..%2F..%2F..%2F..%2Fresources%2Fimg%2Ffigure-12.5.png)

Derlenen bir modulu çalıştırmak için:

- `java --module-path target --module zoo.animal.feeding/zoo.animal.feeding.Task`
- `java -p target -m zoo.animal.feeding/zoo.animal.feeding.Task`

_Jar_ oluşturmak için:
- `jar -cvf mods/zoo.animal.feeding.jar -C feeding/ .`

_Jar_ üzerinden çalıştır:
- `java -p mods -m zoo.animal.feeding/zoo.animal.feeding.Task`

#### Bir Module İçin Uygulanacak Adımlar (_ex01_1_)

1. **Compile**: `javac -p mods -d feeding feeding/zoo/animal/feeding/*.java feeding/*.java`
2. **Run**: `java -p feeding -m feeding/zoo.animal.feeding.Task`
3. **Jar**: `jar -cvf mods/feeding.jar -C feeding/ .`
4. **Run with Jar**: `java -p mods -m feeding/zoo.animal.feeding.Task`

---
### `Diving into the Module Declaration`

### Exporting a Package

Bir paketi spesific bir module açabiliriz. Bunu `to` anahtar kelimesi ile yapabiliriz.

`zoo.animal.talks.content` paketi sadece `zoo.staff` modulune açılmaktadır. 

```java
module zoo.animal.talks {
    exports zoo.animal.talks.content to zoo.staff;
    exports zoo.animal.talks.media;
    exports zoo.animal.talks.schedule;
    
    requires zoo.animal.feeding;
    requires zoo.animal.care;
}
```

### Requiring a Module Transitively

`require transive` ile geçişli bir ilişki kurabiliriz. Yani bu tanım ile işaretlenen moduller alt moduller tarafından da 
kullanılabilecek.

**Figure 12.12** Transitive dependency version of our modules

![figure-12.12.png](..%2F..%2F..%2F..%2Fresources%2Fimg%2Ffigure-12.12.png)


```java
module zoo.animal.feeding {
    exports zoo.animal.feeding;
}
```

```java
module zoo.animal.care {
    exports zoo.animal.care.medical;
    
    // requires zoo.animal.feeding;
    requires transitive zoo.animal.feeding;
}
```

```java
module zoo.animal.talks {
    exports zoo.animal.talks.content to zoo.staff;
    exports zoo.animal.talks.media;
    exports zoo.animal.talks.schedule;

    // no longer needed requires zoo.animal.feeding;
    // no longer needed requires zoo.animal.care;
    requires transitive zoo.animal.care;
}
```

```java
module zoo.staff {
    // no longer needed requires zoo.animal.feeding;
    // no longer needed requires zoo.animal.care;
    requires zoo.animal.talks;
}
```

> Java tekrarlı bir şekilde `requires` ifadesinin kullanılmasına izin vermez.
> ```java
> module bad.module {
>     requires zoo.animal.talks;
>     requires transitive zoo.animal.talks; // DOES NOT COMPILE
> }
> ```

### Opening a Package

`opens` anahtar kelimesi kodu _reflection_ için açar.

Herhangi bir module `zoo.animal.talks.schedule` paketini _reflection_ ile kullanabilir.

Sadece `zoo.staff` modulu `zoo.animal.talks.media` paketini _reflection_ ile kullanabilir.

```java
module zoo.animal.talks {
 opens zoo.animal.talks.schedule;
 opens zoo.animal.talks.media to zoo.staff;
}
```


> Opening an Entire Module
> 
> Module'de ki tüm paketleri reflection için açar.
> 
> ```java
> open module zoo.animal.talks {
> }
> ```
> 
> Java `open` ve `opens` anahtar kelimerini aynı anda kullanmaya izin vermez.
> ```java
> open module zoo.animal.talks {
>    opens zoo.animal.talks.schedule; // DOES NOT COMPILE
> }
> ```