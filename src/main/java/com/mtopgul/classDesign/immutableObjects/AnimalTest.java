package com.mtopgul.classDesign.immutableObjects;

import java.util.ArrayList;

/**
 * @author muhammed-topgul
 * @since 08/02/2024 07:58
 */
public class AnimalTest {
    public static void main(String[] args) {
        animalTest();
        animal1Test();
        animal2Test();
        animal3Test();
    }

    private static void animalTest() {
        Animal zebra = new Animal();
        zebra.getFavoriteFoods().add("Orange");
        System.out.println(zebra.getFavoriteFoods());
        zebra.getFavoriteFoods().clear();
        System.out.println(zebra.getFavoriteFoods());
        System.out.println("-------------------------\n");
    }

    private static void animal1Test() {
        Animal1 zebra = new Animal1();
        System.out.println(zebra.getFavoriteFoodsCount());
        System.out.println(zebra.getFavoriteFood(0));
        System.out.println(zebra.getFavoriteFood(0).substring(1, 4));

        zebra.getFavoriteFoods().add("Orange");
        System.out.println(zebra.getFavoriteFoods());
        zebra.getFavoriteFoods().clear();
        System.out.println(zebra.getFavoriteFoods());
        System.out.println("-------------------------\n");
    }

    private static void animal2Test() {
        ArrayList<String> favorites = new ArrayList<>();
        favorites.add("Apples");
        Animal2 zebra = new Animal2(favorites);

        System.out.println(zebra.getFavoriteFood(0));
        favorites.clear();
        favorites.add("Orange");
        System.out.println(zebra.getFavoriteFood(0));

        System.out.println("-------------------------\n");
    }

    private static void animal3Test() {
        ArrayList<String> favorites = new ArrayList<>();
        favorites.add("Apples");
        Animal3 zebra = new Animal3(favorites);

        System.out.println(zebra.getFavoriteFood(0));
        favorites.clear();
        favorites.add("Orange");
        System.out.println(zebra.getFavoriteFood(0));

        System.out.println("-------------------------\n");
    }
}
