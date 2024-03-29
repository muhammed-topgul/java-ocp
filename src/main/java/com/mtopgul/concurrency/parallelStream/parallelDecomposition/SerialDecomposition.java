package com.mtopgul.concurrency.parallelStream.parallelDecomposition;

import java.time.Duration;
import java.time.Instant;
import java.util.List;

/**
 * @author muhammed-topgul
 * @since 29/03/2024 13:48
 */
public class SerialDecomposition {
    private static int doWork(int input) {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
        }
        return input;
    }

    public static void main(String[] args) {
        Instant start = Instant.now();
        List.of(1,2,3,4,5)
                .stream()
                .map(w -> doWork(w))
                .forEach(s -> System.out.print(s + " "));

        Instant end = Instant.now();
        System.out.println("\nTotal time: " + Duration.between(start, end).toSeconds());
    }
}
