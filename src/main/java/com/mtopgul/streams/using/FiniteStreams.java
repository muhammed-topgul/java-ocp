package com.mtopgul.streams.using;

import java.util.List;
import java.util.stream.Stream;

/**
 * @author muhammed-topgul
 * @since 07/03/2024 15:12
 */
public class FiniteStreams {
    public static void main(String[] args) {
        Stream<String> empty = Stream.empty();
        Stream<Integer> singleElement = Stream.of(1);
        Stream<Integer> fromArray = Stream.of(1, 2, 3);

        List<String> list = List.of("A", "B", "C", "D");
        Stream<String> fromList = list.stream();
        Stream<String> fromListParallel = list.parallelStream();
    }
}
