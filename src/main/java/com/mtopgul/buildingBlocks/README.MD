### _Chapter 01: Building Blocks_
> - **main()** method:
> - **Derle**: `javac -cp . com/mtopgul/buildingBlocks/mainMethod/Zoo.java`
> - **Çalıştır**: `java -cp . com.mtopgul.buildingBlocks.mainMethod.Zoo`
> - **Parametre geç**: `java -cp . com.mtopgul.buildingBlocks.mainMethod.Zoo Bronx "San Diego"`
> - main() parametre formatları:
>> - String[] args
>> - String options []
>> - String... friends
> - public **final** static void main(**final** String[] args) {}
> - Burada `final` anahtar kelimeleri opsiyonel.
 ---
> - **Single-File Source-Code**
> - Tek bir Java sınıfını aynı anda derleyip çalıştırmayı sağlar.
> - `java -cp . com/mtopgul/buildingBlocks/mainMethod/Zoo.java Bronx "Sam"`

> ---
> - **Compiling and Running Code with Packages**
> - _Derleme:_
> - `1.` `javac -cp . com/mtopgul/buildingBlocks/packagesAndImports/b/ClassB.java`
> - `2.` `javac -cp . com/mtopgul/buildingBlocks/packagesAndImports/b/*.java`
> - `3.` `javac -cp . javac -cp . com/mtopgul/buildingBlocks/packagesAndImports/a/ClassA.java com/mtopgul/buildingBlocks/packagesAndImports/b/ClassB.java`
> - `4.` `javac -cp . com/mtopgul/buildingBlocks/packagesAndImports/a/*.java com/mtopgul/buildingBlocks/packagesAndImports/b/*.java`

> - **Başka dizine derleme ve çalıştırma:**
> - `javac -d classes -cp . com/mtopgul/buildingBlocks/packagesAndImports/a/ClassA.java com/mtopgul/buildingBlocks/packagesAndImports/b/ClassB.java`
> - `java -cp classes com.mtopgul.buildingBlocks.packagesAndImports.b.ClassB`
---
> - **Important `javac` options:**
>
> | Option |  Description  |
> |:-----|:--------:|
> | **-cp** | Location of classes needed to compile the program |
> | **-classpath**   |  |
> | **--class-path**   |  |
> | **-d**   | Directory in which to place generated class files |