package com.mtopgul.collectionsAndGenerics.map;

import java.util.Map;

/**
 * @author muhammed-topgul
 * @since 04/03/2024 23:04
 */
public class MapOf {
    public static void main(String[] args) {
        Map<String, String> map1 = Map.of("key1", "value1", "key2", "value");
        System.out.println(map1);

        Map<String, String> map2 = Map.ofEntries(Map.entry("key1", "value1"), Map.entry("key2", "value"));
        System.out.println(map2);

        Map<String, String> map3 = Map.copyOf(map1);
        System.out.println(map3);
    }
}
