package com.mtopgul.concurrency.parallelStream.parallelReductions;

import java.util.List;
import java.util.Set;
import java.util.SortedSet;
import java.util.concurrent.ConcurrentSkipListSet;

/**
 * @author muhammed-topgul
 * @since 29/03/2024 16:18
 */
public class ParallelStreamCollect {
    public static void main(String[] args) {
        serialStreamCollect();
        parallelStreamCollect();
    }

    private static List<String> chars() {
        return List.of("w", "o", "l", "f");
    }

    private static void serialStreamCollect() {
        SortedSet<String> set = chars().stream()
                .collect(ConcurrentSkipListSet::new, Set::add, Set::addAll);
        System.out.println(set);
    }

    private static void parallelStreamCollect() {
        SortedSet<String> set = chars()
                .parallelStream()
                .collect(ConcurrentSkipListSet::new, Set::add, Set::addAll);
        System.out.println(set);
    }
}
