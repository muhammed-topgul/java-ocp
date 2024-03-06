package com.mtopgul.collectionsAndGenerics.generics.typeErasure;

/**
 * @author muhammed-topgul
 * @since 06/03/2024 12:53
 */
public class Main {
    public static void main(String[] args) {
        CrateV1 v1 = new CrateV1();
        v1.packCrate(new Dog("Tom"));
//        v1.packCrate(10);  // ClassCastException
        Dog dog = (Dog) v1.lookInCrate();
        System.out.println(dog.name());

        CrateV2<Dog> v2 = new CrateV2<>();
        v2.packCrate(new Dog("Sam"));
//        v2.packCrate(10);  // DOES NOT COMPILE
        Dog dog1 = v2.lookInCrate();
        System.out.println(dog1.name());
    }
}
