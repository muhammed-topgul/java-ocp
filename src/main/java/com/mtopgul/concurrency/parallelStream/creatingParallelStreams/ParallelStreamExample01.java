package com.mtopgul.concurrency.parallelStream.creatingParallelStreams;

import java.util.Collection;
import java.util.List;
import java.util.stream.Stream;

/**
 * @author muhammed-topgul
 * @since 29/03/2024 10:35
 */
public class ParallelStreamExample01 {
    public static void main(String[] args) {
        Collection<Integer> collection = List.of(1, 2);
        Stream<Integer> parallel1 = collection.stream().parallel();
        Stream<Integer> parallel2 = collection.parallelStream();
    }
}
