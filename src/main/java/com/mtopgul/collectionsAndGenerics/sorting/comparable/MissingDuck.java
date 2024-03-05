package com.mtopgul.collectionsAndGenerics.sorting.comparable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.TreeSet;

/**
 * @author muhammed-topgul
 * @since 05/03/2024 09:57
 */
public class MissingDuck implements Comparable<MissingDuck> {
    private final String name;

    public MissingDuck(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public int compareTo(MissingDuck duck) {
        if (duck == null) {
            throw new IllegalArgumentException("Poorly formed duck!");
        }
        if (this.name == null && duck.name == null) {
            return 0;
        }
        if (this.name == null) {
            return -1;
        }
        if (duck.name == null) {
            return 1;
        }
        return name.compareTo(duck.name);
    }

    public static void main(String[] args) {
        var ducks = new ArrayList<MissingDuck>();
        ducks.add(new MissingDuck(null));
        ducks.add(new MissingDuck("Quack"));
        ducks.add(new MissingDuck("Puddles"));
        ducks.add(new MissingDuck("Aaron"));

        Collections.sort(ducks);    // Sort by name
        System.out.println(ducks);  // [Aaron, Puddles, Quack]
    }
}
