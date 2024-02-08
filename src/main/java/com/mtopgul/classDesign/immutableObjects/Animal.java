package com.mtopgul.classDesign.immutableObjects;

import java.util.ArrayList;

/**
 * @author muhammed-topgul
 * @since 08/02/2024 07:56
 */
public final class Animal {
    private final ArrayList<String> favoriteFoods;

    public Animal() {
        this.favoriteFoods = new ArrayList<>();
        this.favoriteFoods.add("Apples");
    }

    public ArrayList<String> getFavoriteFoods() {
        return favoriteFoods;
    }
}
