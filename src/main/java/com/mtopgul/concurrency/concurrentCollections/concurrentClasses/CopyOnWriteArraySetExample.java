package com.mtopgul.concurrency.concurrentCollections.concurrentClasses;

import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * @author muhammed-topgul
 * @since 28/03/2024 17:36
 */
public class CopyOnWriteArraySetExample {
    public static void main(String[] args) {
        Set<Integer> set = new CopyOnWriteArraySet<>();
        set.add(10);
        set.add(10);
        set.add(30);
        set.add(20);
        set.add(5);
        System.out.println(set); // [10, 30, 20, 5]
    }
}
