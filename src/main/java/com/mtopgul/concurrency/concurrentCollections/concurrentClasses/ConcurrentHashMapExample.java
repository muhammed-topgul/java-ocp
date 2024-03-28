package com.mtopgul.concurrency.concurrentCollections.concurrentClasses;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author muhammed-topgul
 * @since 28/03/2024 17:24
 */
public class ConcurrentHashMapExample {
    public static void main(String[] args) {
        Map<String, Integer> concurrentMap = new ConcurrentHashMap<>();
        concurrentMap.put("key1", 10);
        concurrentMap.put("key2", 20);

        System.out.println(concurrentMap);
    }
}
