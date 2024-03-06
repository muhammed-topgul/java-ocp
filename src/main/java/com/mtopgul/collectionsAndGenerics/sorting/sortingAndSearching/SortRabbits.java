package com.mtopgul.collectionsAndGenerics.sorting.sortingAndSearching;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author muhammed-topgul
 * @since 06/03/2024 09:46
 */
public class SortRabbits {
    static record Rabbit(int id) {
    }

    public static void main(String[] args) {
        List<Rabbit> rabbits = new ArrayList<>();
        rabbits.add(new Rabbit(3));
        rabbits.add(new Rabbit(1));

        // Collections.sort(rabbits); // DOES NOT COMPILE because rabbits does not implements Comparable interface
        Comparator<Rabbit> comparator = Comparator.comparingInt(r -> r.id);
        Collections.sort(rabbits, comparator);

        System.out.println(rabbits); // [Rabbit[id=1], Rabbit[id=3]]

        Collections.reverse(rabbits);
        System.out.println(rabbits); // [Rabbit[id=3], Rabbit[id=1]]
    }
}
