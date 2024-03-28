package com.mtopgul.concurrency.concurrentCollections.memoryConsistencyErrors;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @author muhammed-topgul
 * @since 28/03/2024 14:40
 */
public class AvoidConcurrentModificationExceptionExample {
    public static void main(String[] args) {
        var foodData = new ConcurrentHashMap<String, Integer>();
        foodData.put("penguin", 1);
        foodData.put("flamingo", 2);
        for (String key : foodData.keySet()) {
            System.out.println(key);
            foodData.put(key + "-exception", 3);
        }

        for (String key : foodData.keySet()) {
            if (key.equals("penguin")) {
                foodData.remove(key);
            }
        }

        for (String key : foodData.keySet()) {
            System.out.println(key);
        }
    }
}
