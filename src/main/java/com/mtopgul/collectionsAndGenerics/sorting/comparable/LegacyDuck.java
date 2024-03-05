package com.mtopgul.collectionsAndGenerics.sorting.comparable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.TreeSet;

/**
 * @author muhammed-topgul
 * @since 05/03/2024 09:55
 */
public class LegacyDuck implements Comparable {
    private final String name;

    public LegacyDuck(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public int compareTo(Object object) {
        LegacyDuck duck = (LegacyDuck) object;
        return name.compareTo(duck.name);
    }

    public static void main(String[] args) {
        var ducks = new ArrayList<LegacyDuck>();
        ducks.add(new LegacyDuck("Quack"));
        ducks.add(new LegacyDuck("Puddles"));
        ducks.add(new LegacyDuck("Aaron"));

        Collections.sort(ducks);    // Sort by name
        System.out.println(ducks);  // [Aaron, Puddles, Quack]

        var set = new TreeSet<LegacyDuck>();
        set.add(new LegacyDuck("Quack"));
        set.add(new LegacyDuck("Puddles"));
        set.add(new LegacyDuck("Aaron"));
        System.out.println(set);    // [Aaron, Puddles, Quack]
    }
}
