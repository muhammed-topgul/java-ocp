package com.mtopgul.classDesign.immutableObjects;

import java.util.ArrayList;

/**
 * @author muhammed-topgul
 * @since 08/02/2024 07:56
 */
public final class Animal3 {
    private final ArrayList<String> favoriteFoods;

    public Animal3(ArrayList<String> favoriteFoods) {
        if (favoriteFoods == null || favoriteFoods.isEmpty())
            throw new RuntimeException("favoriteFoods is required");
        this.favoriteFoods = new ArrayList<>(favoriteFoods);
    }

    public ArrayList<String> getFavoriteFoods() {
        return new ArrayList<>(favoriteFoods);
    }

    public int getFavoriteFoodsCount() {
        return favoriteFoods.size();
    }

    public String getFavoriteFood(int index) {
        return favoriteFoods.get(index);
    }
}
