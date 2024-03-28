package com.mtopgul.concurrency.concurrentCollections.concurrentClasses;

import java.util.Set;
import java.util.concurrent.ConcurrentSkipListSet;

/**
 * @author muhammed-topgul
 * @since 28/03/2024 17:32
 */
public class ConcurrentSkipListSetExample {
    public static void main(String[] args) {
        Set<Integer> set = new ConcurrentSkipListSet<>();
        set.add(10);
        set.add(10);
        set.add(30);
        set.add(20);
        set.add(5);
        System.out.println(set); // [5, 10, 20, 30]
    }
}
