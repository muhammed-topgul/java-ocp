package com.mtopgul.streams.advanced.collecting;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import static com.mtopgul.streams.advanced.collecting.BasicCollectors.animalStream;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.mapping;
import static java.util.stream.Collectors.minBy;

/**
 * @author muhammed-topgul
 * @since 11/03/2024 16:34
 */
public class PartitioningBy {
    public static void main(String[] args) {
        Map<Boolean, List<String>> map1 = animalStream()
                .collect(Collectors.partitioningBy(s -> s.length() <= 5));
        System.out.println(map1);  // {false=[tigers], true=[lions, bears]}

        Map<Boolean, List<String>> map2 = animalStream()
                .collect(Collectors.partitioningBy(s -> s.length() <= 7));
        System.out.println(map2);  // {false=[], true=[lions, tigers, bears]}

        Map<Boolean, Set<String>> map3 = animalStream()
                .collect(
                        Collectors.partitioningBy(
                                s -> s.length() <= 7,
                                Collectors.toSet()
                        ));
        System.out.println(map3);  // {false=[], true=[lions, bears, tigers]}

        Map<Integer, Long> map4 = animalStream().collect(
                groupingBy(
                        String::length,
                        Collectors.counting()
                )
        );
        System.out.println(map4);  // {5=2, 6=1}


        Map<Integer, List<String>> map5 = animalStream()
                .collect(groupingBy(String::length));
        System.out.println(map5);  // {5=[lions, bears], 6=[tigers]}

        Map<Integer, Optional<Character>> map6 = animalStream()
                .collect(
                        groupingBy(
                                String::length,
                                Collectors.mapping(
                                        s -> s.charAt(0),
                                        Collectors.minBy((a, b) -> a - b)
                                )
                        )
                );
        System.out.println(map6);  // {5=Optional[b], 6=Optional[t]}

        var map7 = animalStream().collect(
                groupingBy(
                        String::length,
                        mapping(
                                s -> s.charAt(0),
                                minBy(Comparator.comparingInt(a -> a))
                        ))
        );
        System.out.println(map7);
    }
}
