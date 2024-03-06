package com.mtopgul.collectionsAndGenerics.sorting.comparator;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.TreeSet;
import java.util.stream.Collectors;

/**
 * @author muhammed-topgul
 * @since 05/03/2024 09:15
 */
public class Duck implements Comparable<Duck> {
    private final String name;
    private final int weight;

    public Duck(String name, int weight) {
        this.name = name;
        this.weight = weight;
    }

    public int getWeight() {
        return weight;
    }

    @Override
    public int compareTo(Duck duck) {
        return name.compareTo(duck.name);
    }

    @Override
    public String toString() {
        return "%s(%d)".formatted(name, weight);
    }

    public static void main(String[] args) {
        Comparator<Duck> byWeightInc = new Comparator<Duck>() {
            @Override
            public int compare(Duck d1, Duck d2) {
                return d1.weight - d2.weight;
            }
        };

        Comparator<Duck> byWeightInc1 = Comparator.comparing(d -> d.weight);
        // Comparator<Duck> byWeightInc1 = Comparator.comparing(Duck::getWeight);


        Comparator<Duck> byWeightDec = (d1, d2) -> d2.weight - d1.weight;


        var ducks = new ArrayList<Duck>();
        ducks.add(new Duck("Quack", 7));
        ducks.add(new Duck("Puddles", 10));
        ducks.add(new Duck("Aaron", 5));

        ducks.sort(byWeightDec);
        System.out.println(ducks);  // [Puddles(10), Quack(7), Aaron(5)]

        var set = new TreeSet<>(byWeightInc1);
        set.add(new Duck("Quack", 7));
        set.add(new Duck("Puddles", 10));
        set.add(new Duck("Aaron", 5));
        System.out.println(set);    // [Aaron(5), Quack(7), Puddles(10)]

        LinkedHashSet<Duck> reveresSet = set.stream()
                .sorted(byWeightInc)
                .collect(Collectors.toCollection(LinkedHashSet::new));
        System.out.println(reveresSet); // [Aaron(5), Quack(7), Puddles(10)]
    }
}
