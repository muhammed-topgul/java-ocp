package com.mtopgul.streams.using;

import com.mtopgul.Util;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Stream;

/**
 * @author muhammed-topgul
 * @since 07/03/2024 15:56
 */
public class TerminalOperations {
    public static void main(String[] args) {
        // count()
        Util.divide("count()");
        System.out.println(primates().count()); // 4

        // min() max()
        Util.divide("min() max()");
        Optional<String> max = primates().max(Comparator.comparingInt(String::length));
        max.ifPresent(System.out::println);   // Gorilla

        Optional<String> min = primates().min(Comparator.comparingInt(String::length));
        min.ifPresent(System.out::println);  // Ape

        // findFirst() findAny()
        Util.divide("findFirst() findAny()");
        primates().findAny().ifPresent(System.out::println);    // Monkey (usually)
        Stream.generate(() -> "Chimp").findAny()
                .ifPresent(System.out::println);                // Chimp

        primates().findFirst().ifPresent(System.out::println);  // Monkey
        Stream.generate(() -> "Chimp").findFirst()
                .ifPresent(System.out::println);                // Chimp

        // anyMatch() allMatch() noneMatch()
        Util.divide("anyMatch() allMatch() noneMatch()");
        Predicate<String> pred = s -> Character.isLetter(s.charAt(0));
        System.out.println(list().stream().anyMatch(pred));  // true
        System.out.println(list().stream().allMatch(pred));  // false
        System.out.println(list().stream().noneMatch(pred)); // false
        System.out.println(Stream.generate(() -> "Chimp").anyMatch((s) -> {
            System.out.println("- " + s);
            return Character.isLetter(s.charAt(0));
        })); // true

        // forEach()
        Util.divide("forEach()");
        primates().forEach(System.out::println);

        // reduce()

    }

    private static Stream<String> primates() {
        return Stream.of("Monkey", "Gorilla", "Bonobo", "Ape");
    }

    private static List<String> list() {
        return List.of("Monkey", "2", "Chimp");
    }
}
