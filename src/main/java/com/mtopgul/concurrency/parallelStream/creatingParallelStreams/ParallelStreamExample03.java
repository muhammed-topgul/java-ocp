package com.mtopgul.concurrency.parallelStream.creatingParallelStreams;

import java.time.Duration;
import java.time.Instant;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @author muhammed-topgul
 * @since 29/03/2024 12:24
 */
public class ParallelStreamExample03 {
    public static void main(String[] args) {
        Instant startTime = Instant.now();

        long count = Stream.iterate(0, n -> n + 1)
                // .parallel()
                .limit(1_000_000)
                .filter(ParallelStreamExample03::isPrime)
                 .peek(x -> System.out.printf("%s\t", x))
                .count();

        System.out.println("\nTotal: " + count);

        Instant endTime = Instant.now();
        Duration elapsedTime = Duration.between(startTime, endTime);
        System.out.println(elapsedTime.toSeconds());
    }

    private static boolean isPrime(int number) {
        if (number <= 1) {
            return false;
        }
        return IntStream.rangeClosed(2, number / 2)
                .anyMatch(i -> number % i == 0);
    }
}
