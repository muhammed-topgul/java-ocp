package com.mtopgul.streams.primitive;

import java.util.stream.Stream;

/**
 * @author muhammed-topgul
 * @since 11/03/2024 10:10
 */
public class FirstExample {
    public static void main(String[] args) {
        int sum = numStream().reduce(0, (total, number) -> total + number);
        System.out.println(sum); // 6

        sum = numStream()
                .mapToInt(x -> x)
                .sum();
        System.out.println(sum); // 6

        double average = numStream()
                .mapToInt(x -> x)
                .average()
                .getAsDouble();
        System.out.println(average); // 2.0
    }

    private static Stream<Integer> numStream() {
        return Stream.of(1, 2, 3);
    }
}
