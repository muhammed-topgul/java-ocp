package com.mtopgul.streams.using;

import com.mtopgul.Util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author muhammed-topgul
 * @since 11/03/2024 09:18
 */
public class PuttingTogether {
    public static void main(String[] args) {
        Util.divide("Old Style");
        var list = List.of("Toby", "Anna", "Leroy", "Alex");
        List<String> filtered = new ArrayList<>();
        for (String name : list) {
            if (name.length() == 4) {
                filtered.add(name);
                System.out.println("*" + name);
            }
        }
        Collections.sort(filtered);
        for (int i = 0; i < 2; i++) {
            if (filtered.get(i) != null) {
                System.out.println(filtered.get(i)); // Alex Anna
            }
        }

        Util.divide("Stream Style");
        list.stream()
                .filter(n -> n.length() == 4)
                .peek(s -> System.out.println("*" + s))
                .sorted()
                .limit(2)
                .forEach(System.out::println);

        Util.divide();
        long count = Stream.of("goldfish", "finch")
                .filter(s -> s.length() > 5)
                .collect(Collectors.toList())
                .stream()
                .count();
        System.out.println(count); // 1
    }
}
