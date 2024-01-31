package com.mtopgul.coreApis.array;

/**
 * @author muhammed-topgul
 * @since 31/01/2024 07:49
 */
public class CreatingAnArrayWithReferenceVariablesCasting2 {
    public static void main(String[] args) {
        {
            Animal[] animals = new Dog[3];
            animals[0] = new Dog();
            animals[1] = new Dog();
            animals[2] = new Dog();

            Dog[] dogs = (Dog[]) animals;
            animals[0] = new Cat(); // ArrayStoreException
        }
    }
}
