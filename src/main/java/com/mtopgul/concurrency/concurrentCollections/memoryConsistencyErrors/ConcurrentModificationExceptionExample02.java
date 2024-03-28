package com.mtopgul.concurrency.concurrentCollections.memoryConsistencyErrors;

import java.util.HashMap;

/**
 * @author muhammed-topgul
 * @since 28/03/2024 14:35
 */
public class ConcurrentModificationExceptionExample02 {
    public static void main(String[] args) {
        var foodData = new HashMap<String, Integer>();
        foodData.put("penguin", 1);
        foodData.put("flamingo", 2);
        for (String key : foodData.keySet()) {
            foodData.put(key + "-exception", 3);
        }
    }
}
