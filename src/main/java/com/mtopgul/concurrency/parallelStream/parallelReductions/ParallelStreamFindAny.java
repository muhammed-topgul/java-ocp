package com.mtopgul.concurrency.parallelStream.parallelReductions;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author muhammed-topgul
 * @since 29/03/2024 14:00
 */
public class ParallelStreamFindAny {
    public static void main(String[] args) {
        parallelStreamFindAny();
        serialStreamFindAny();
    }

    private static void parallelStreamFindAny() {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < 1000; i++) {
            int findAnyNumber = List.of(1, 2, 3, 4, 5, 6)
                    .parallelStream()
                    .findAny()
                    .get();
            set.add(findAnyNumber);
        }
        System.out.println("Parallel Stream Result: " + set);
    }

    private static void serialStreamFindAny() {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < 100; i++) {
            int findAnyNumber = List.of(1, 2, 3, 4, 5, 6)
                    .stream()
                    .findAny()
                    .get();
            set.add(findAnyNumber);
        }
        System.out.println("Serial Stream Result: " + set);
    }
}
