package com.mtopgul.collectionsAndGenerics.sorting.comparable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.TreeSet;

/**
 * @author muhammed-topgul
 * @since 05/03/2024 09:15
 */
public class Duck implements Comparable<Duck> {
    private final String name;

    public Duck(String name) {
        this.name = name;
    }

    @Override
    public int compareTo(Duck duck) {
        return name.compareTo(duck.name); // ASC
//        return duck.name.compareTo(name); // DESC
    }

    @Override
    public String toString() {
        return name;
    }

    public static void main(String[] args) {
        var ducks = new ArrayList<Duck>();
        ducks.add(new Duck("Quack"));
        ducks.add(new Duck("Puddles"));
        ducks.add(new Duck("Aaron"));

        Collections.sort(ducks);    // Sort by name
        System.out.println(ducks);  // [Aaron, Puddles, Quack]

        var set = new TreeSet<Duck>();
        set.add(new Duck("Quack"));
        set.add(new Duck("Puddles"));
        set.add(new Duck("Aaron"));
        System.out.println(set);    // [Aaron, Puddles, Quack]
    }
}
