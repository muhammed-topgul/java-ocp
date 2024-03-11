package com.mtopgul.streams.advanced.collecting;

import com.mtopgul.Util;

import java.util.List;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author muhammed-topgul
 * @since 11/03/2024 15:05
 */
public class BasicCollectors {
    public static void main(String[] args) {
        List<String> list1 = animalStream().collect(Collectors.toList());
        List<String> list2 = animalStream().toList();
        System.out.println(list1);   // [lions, tigers, bears]
        System.out.println(list2);   // [lions, tigers, bears]

        Util.divide("joining()");
        String joinedString = animalStream().collect(Collectors.joining(", "));
        System.out.println(joinedString); // lions, tigers, bears

        Util.divide("averagingInt()");
        Double average = animalStream().collect(Collectors.averagingInt(String::length));
        System.out.println(average);      // 5.333333333333333


        Util.divide("toCollection()");
        TreeSet<String> treeSet = animalStream().filter(s -> s.contains("i"))
                .collect(Collectors.toCollection(TreeSet::new));
        System.out.println(treeSet);  // [lions, tigers]
    }

    public static Stream<String> animalStream() {
        return Stream.of("lions", "tigers", "bears");
    }
}
