package com.mtopgul.collectionsAndGenerics.generics.creating;

/**
 * @author muhammed-topgul
 * @since 06/03/2024 10:47
 */
public class Elephant {
    public static void main(String[] args) {
        Elephant elephant = new Elephant();
        Crate<Elephant> crateForElephant = new Crate<>();
        crateForElephant.packCrate(elephant);
        Elephant inNewHome = crateForElephant.lookInCrate();
    }
}
