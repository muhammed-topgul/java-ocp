package com.mtopgul.collectionsAndGenerics.sorting.comparator;

import java.util.Comparator;

/**
 * @author muhammed-topgul
 * @since 06/03/2024 09:24
 */
public class MultiFieldComparator implements Comparator<Squirrel> {
    @Override
    public int compare(Squirrel s1, Squirrel s2) {
        int bySpecies = s1.getSpecies().compareTo(s2.getSpecies());
        if (bySpecies != 0) {
            return bySpecies;
        }
        return s1.getWeight() - s2.getWeight();
    }
}
