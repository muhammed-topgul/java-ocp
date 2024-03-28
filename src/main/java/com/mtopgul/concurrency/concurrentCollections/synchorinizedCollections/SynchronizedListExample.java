package com.mtopgul.concurrency.concurrentCollections.synchorinizedCollections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author muhammed-topgul
 * @since 28/03/2024 17:45
 */
public class SynchronizedListExample {
    public static void main(String[] args) {
        List<Integer> original = new ArrayList<>();
        original.add(1);
        original.add(2);
        original.add(3);
        original.add(4);

        List<Integer> list = Collections.synchronizedList(original);
        list.add(10);

        System.out.println(original); // [1, 2, 3, 4, 10]
        System.out.println(list);     // [1, 2, 3, 4, 10]
    }
}
