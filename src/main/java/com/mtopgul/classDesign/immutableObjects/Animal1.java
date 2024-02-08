package com.mtopgul.classDesign.immutableObjects;

import java.util.ArrayList;
import java.util.List;

/**
 * @author muhammed-topgul
 * @since 08/02/2024 07:56
 */
public final class Animal1 {
    private final ArrayList<String> favoriteFoods;

    public Animal1() {
        this.favoriteFoods = new ArrayList<>();
        this.favoriteFoods.add("Apples");
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
