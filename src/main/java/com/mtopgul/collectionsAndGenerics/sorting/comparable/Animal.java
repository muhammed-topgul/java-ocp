package com.mtopgul.collectionsAndGenerics.sorting.comparable;

/**
 * @author muhammed-topgul
 * @since 05/03/2024 09:46
 */
public class Animal implements Comparable<Animal> {
    private final int id;

    public Animal(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    @Override
    public int compareTo(Animal animal) {
        // return id - animal.id;
        return Integer.compare(id, animal.id);
    }

    public static void main(String[] args) {
        Animal a1 = new Animal(5);
        Animal a2 = new Animal(7);

        System.out.println(a1.compareTo(a2)); // -2
        System.out.println(a1.compareTo(a1)); // 0
        System.out.println(a2.compareTo(a1)); // 2
    }
}
