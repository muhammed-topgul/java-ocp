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