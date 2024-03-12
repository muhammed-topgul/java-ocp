package com.mtopgul.streams.advanced.collecting;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.stream.Collectors;

import static com.mtopgul.streams.advanced.collecting.BasicCollectors.animalStream;

/**
 * @author muhammed-topgul
 * @since 11/03/2024 16:07
 */
public class GroupingBy {
    public static void main(String[] args) {
        Map<Integer, List<String>> map1 = animalStream()
                .collect(Collectors.groupingBy(a -> a.length()));
        System.out.println(map1); // {5=[lions, bears], 6=[tigers]}

        Map<Integer, Set<String>> map2 = animalStream()
                .collect(Collectors.groupingBy(String::length, Collectors.toSet()));
        System.out.println(map2);

        TreeMap<Integer, Set<String>> map3 = animalStream()
                .collect(Collectors.groupingBy(
                        String::length,
                        () -> new TreeMap<>(Comparator.reverseOrder()),
                        Collectors.toSet()
                ));
        System.out.println(map3); // {6=[tigers], 5=[lions, bears]}

        TreeMap<Integer, List<String>> map4 = animalStream()
                .collect(Collectors.groupingBy(
                        String::length,
                        TreeMap::new,
                        Collectors.toList()
                ));
        System.out.println(map4); // {5=[lions, bears], 6=[tigers]}
    }
}
