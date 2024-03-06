package com.mtopgul.collectionsAndGenerics.sorting.comparator;

import java.util.Comparator;

/**
 * @author muhammed-topgul
 * @since 06/03/2024 09:21
 */
public class Squirrel {
    private final int weight;
    private final String species;

    public Squirrel(int weight, String species) {
        this.weight = weight;
        this.species = species;
    }

    public int getWeight() {
        return weight;
    }

    public String getSpecies() {
        return species;
    }

    public static void main(String[] args) {
        Comparator<Squirrel> bySpeciesAndWeight = Comparator.comparing((Squirrel s) -> s.getSpecies())
                .thenComparingInt(s -> s.getWeight());
        Comparator<Squirrel> bySpeciesAndWeightReversed = Comparator.comparing(Squirrel::getSpecies)
                .thenComparingInt(Squirrel::getWeight)
                .reversed();

        Comparator<Squirrel> comparing = Comparator.comparing(Squirrel::getSpecies);
    }
}
