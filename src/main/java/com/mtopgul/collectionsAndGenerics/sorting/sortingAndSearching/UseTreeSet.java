package com.mtopgul.collectionsAndGenerics.sorting.sortingAndSearching;

import java.util.Set;
import java.util.TreeSet;

/**
 * @author muhammed-topgul
 * @since 06/03/2024 09:55
 */
public class UseTreeSet {
    record Rabbit(int id) /*implements Comparable<Rabbit>*/ {
//        @Override
//        public int compareTo(Rabbit o) {
//            return 0;
//        }
    }

    public static void main(String[] args) {
        TreeSet<Rabbit> rabbits = new TreeSet<>();
        rabbits.add(new Rabbit(1)); // ClassCastException
    }
}
