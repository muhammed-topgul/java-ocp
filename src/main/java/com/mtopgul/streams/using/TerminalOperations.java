package com.mtopgul.streams.using;

import com.mtopgul.Util;

import java.util.*;
import java.util.function.BinaryOperator;
import java.util.function.Predicate;
import java.util.stream.Collectors;
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
        Util.divide("reduce()");
        var array = new String[]{"w", "o", "l", "f"};
        var wolf = "";
        for (var s : array) {
            wolf += s;
        }
        System.out.println(wolf);

        wolf = Arrays.stream(array).reduce("", (s, c) -> s + c);
        System.out.println(wolf);

        wolf = Arrays.stream(array).reduce("", String::concat);
        System.out.println(wolf);

        Stream<Integer> stream = Stream.of(3, 5, 6);
        System.out.println(stream.reduce(1, (a, b) -> a * b)); // 90
        BinaryOperator<Integer> opt = (a, b) -> a * b;
        Stream<Integer> empty = Stream.empty();
        Stream<Integer> oneElement = Stream.of(3);
        Stream<Integer> threeElements = Stream.of(3, 5, 6);
        oneElement.reduce(opt).ifPresent(System.out::println);    // 3
        empty.reduce(opt).ifPresent(System.out::println);         // No output
        threeElements.reduce(opt).ifPresent(System.out::println); // 90

        Stream<String> newStream = Stream.of("w", "o", "l", "f!");
        int length = newStream.reduce(0, (i, s) -> i + s.length(), (a, b) -> a + b);
        System.out.println(length); // 5

        // collect()
        Stream<String> wolfStream = wolfStream();
        StringBuilder newWolf = wolfStream.collect(() -> new StringBuilder(), (sb, newStr) -> sb.append(newStr), (sb1, sb2) -> sb1.append(sb2));
        System.out.println(newWolf); // wolf

        Set<String> set = wolfStream().collect(() -> new TreeSet<>(), (ts, str) -> ts.add(str), (ts1, ts2) -> ts1.addAll(ts2));
        System.out.println(set);     // [f, l, o, w]

        set = wolfStream().collect(Collectors.toCollection(() -> new TreeSet<>()));
        System.out.println(set);     // [f, l, o, w]

        set = wolfStream().collect(Collectors.toSet());
        System.out.println(set);     // [f, w, l, o]

    }

    private static Stream<String> wolfStream() {
        return Stream.of("w", "o", "l", "f");
    }

    public static Stream<String> primates() {
        return Stream.of("Monkey", "Gorilla", "Bonobo", "Ape");
    }

    private static List<String> list() {
        return List.of("Monkey", "2", "Chimp");
    }
}
