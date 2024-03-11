package com.mtopgul.streams.advanced.collecting;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

import static com.mtopgul.streams.advanced.collecting.BasicCollectors.animalStream;

/**
 * @author muhammed-topgul
 * @since 11/03/2024 15:42
 */
public class CollectingIntoMaps {
    public static void main(String[] args) {
        Map<String, Integer> map1 = animalStream()
                .collect(Collectors.toMap(k -> k, v -> v.length()));
        System.out.println(map1);  // {lions=5, bears=5, tigers=6}

        // Map<Integer, String> map2 = animalStream()
        //        .collect(Collectors.toMap(k -> k.length(), v -> v));  // IllegalStateException: Duplicate key 5

        Map<Integer, String> map2 = animalStream()
                .collect(Collectors.toMap(String::length, k -> k, (s1, s2) -> s1 + "," + s2));
        System.out.println(map2); // {5=lions,bears, 6=tigers}

        TreeMap<Integer, String> treeMap = animalStream()
                .collect(Collectors.toMap(
                        String::length,
                        v -> v,
                        (s1, s2) -> s1 + "," + s2,
                        () -> new TreeMap<>(Comparator.reverseOrder()))
                );
        System.out.println(treeMap); // {6=tigers, 5=lions,bears}
    }
}
