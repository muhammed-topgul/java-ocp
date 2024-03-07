package com.mtopgul.streams.using;

import java.util.stream.Stream;

/**
 * @author muhammed-topgul
 * @since 07/03/2024 15:20
 */
public class InfiniteStreams {
    public static void main(String[] args) {
        Stream<Double> randoms = Stream.generate(() -> Math.random());
        // randoms.forEach(System.out::println);

        Stream<Integer> oddNumbers = Stream.iterate(1, n -> n + 2);
        // oddNumbers.forEach(System.out::println);

        Stream<Integer> oddNumbersUnder100 = Stream.iterate(1, n -> n < 100, n -> n + 2);
        oddNumbersUnder100.forEach(System.out::println);
    }
}
