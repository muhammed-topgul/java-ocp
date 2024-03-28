package com.mtopgul.concurrency.concurrentCollections.concurrentClasses;

import java.util.Map;
import java.util.concurrent.ConcurrentSkipListMap;

/**
 * @author muhammed-topgul
 * @since 28/03/2024 17:29
 */
public class ConcurrentSkipListMapExample {
    public static void main(String[] args) {
        Map<Integer, String> map = new ConcurrentSkipListMap<>();
        map.put(10, "value1");
        map.put(100, "value2");
        map.put(80, "value3");
        map.put(60, "value4");
        map.put(40, "value5");

        System.out.println(map); // {10=value1, 40=value5, 60=value4, 80=value3, 100=value2}
    }
}
