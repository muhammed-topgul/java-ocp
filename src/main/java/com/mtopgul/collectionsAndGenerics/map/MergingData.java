package com.mtopgul.collectionsAndGenerics.map;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;

/**
 * @author muhammed-topgul
 * @since 05/03/2024 00:16
 */
public class MergingData {
    public static void main(String[] args) {
        BiFunction<String, String, String> mapper1 = (v1, v2) -> v1.length() > v2.length() ? v1 : v2;
        Map<String, String> favorites = new HashMap<>();
        favorites.put("Jenny", "Bus Tour");
        favorites.put("Tom", "Tram");

        String jenny = favorites.merge("Jenny", "Skyride", mapper1);
        String tom = favorites.merge("Tom", "Skyride", mapper1);

        System.out.println(favorites); // {Tom=Skyride, Jenny=Bus Tour}
        System.out.println(jenny);     // Bus Tour
        System.out.println(tom);       // Skyride


        favorites.put("Sam", null);
        String sam = favorites.merge("Sam", "Skyride", mapper1);
        System.out.println(favorites);  // {Tom=Skyride, Jenny=Bus Tour, Sam=Skyride}
        System.out.println(sam);        // Skyride


        favorites.remove("Sam");
        BiFunction<String, String, String> mapper2 = (v1, v2) -> null;
        jenny = favorites.merge("Jenny", "Skyride", mapper2);
        sam = favorites.merge("Sam", "Skyride", mapper2);
        System.out.println(favorites);  // {Tom=Skyride, Sam=Skyride}
        System.out.println(jenny);      // null
        System.out.println(sam);        // Skyride
    }
}
