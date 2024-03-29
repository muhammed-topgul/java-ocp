package com.mtopgul.concurrency.parallelStream.parallelReductions;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.IntStream;

/**
 * @author muhammed-topgul
 * @since 29/03/2024 14:06
 */
public class ParallelStreamFindFirst {
    public static void main(String[] args) {
        parallelStreamFindFirst();
        serialStreamFindFirst();
    }

    private static void parallelStreamFindFirst() {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < 1000; i++) {
            int findFirst = IntStream.rangeClosed(1, 20)
                    .parallel()
                    .skip(5)
                    .limit(2)
                    .findFirst()
                    .getAsInt();
            set.add(findFirst);
        }
        System.out.println("Parallel Stream Result: " + set);
    }

    private static void serialStreamFindFirst() {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < 100; i++) {
            int findFirst = IntStream.rangeClosed(1, 20)
                    .skip(5)
                    .limit(2)
                    .findFirst()
                    .getAsInt();
            set.add(findFirst);
        }
        System.out.println("\nSerial Stream Result: " + set);
    }
}
