package com.mtopgul.concurrency.concurrentCollections.concurrentClasses;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author muhammed-topgul
 * @since 28/03/2024 17:34
 */
public class CopyOnWriteArrayListExample {
    public static void main(String[] args) {
        List<Integer> favNumbers = new CopyOnWriteArrayList<>(List.of(4, 3, 42));
        for (Integer number : favNumbers) {
            System.out.print(number + " "); // 4 3 42
            favNumbers.add(number + 1);
        }

        System.out.println();
        System.out.println("size: " + favNumbers.size()); // 6
        System.out.println(favNumbers); // [4, 3, 42, 5, 4, 43]
    }
}
