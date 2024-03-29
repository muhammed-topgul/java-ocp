package com.mtopgul.concurrency.parallelStream.creatingParallelStreams;

import java.util.stream.IntStream;

/**
 * @author muhammed-topgul
 * @since 29/03/2024 10:36
 */
public class ParallelStreamExample02 {
    public static void main(String[] args) {
        System.out.println("Serial Stream: ");
        IntStream serialStream = IntStream.rangeClosed(1, 10);
        serialStream.forEach(i -> System.out.println(i + " " + Thread.currentThread().getName()));

        System.out.println("\nParallel Stream: ");
        IntStream parallelStream = IntStream.rangeClosed(1, 10)
                .parallel();
        parallelStream.forEach(i -> System.out.println(i + " " + Thread.currentThread().getName()));
    }
}
