package com.mtopgul.collectionsAndGenerics.map;

import java.util.HashMap;
import java.util.Map;

/**
 * @author muhammed-topgul
 * @since 04/03/2024 23:14
 */
public class MapMethods {
    public static void main(String[] args) {
        HashMap<Integer, String> map = new HashMap<>();
        map.put(1, "Slot");
        map.put(2, "Tiger");
        map.put(3, "Mammoth");
        map.put(4, "Squirrel");

        // map.clear();
        System.out.println(map.containsKey(2));            // true
        System.out.println(map.containsValue("Mammoth"));  // true
        System.out.println(map.entrySet());                // [1=Slot, 2=Tiger, 3=Mammoth, 4=Squirrel]
        map.forEach((k, v) ->
                System.out.println(k + " -> " + v));       // 1 -> Slot 2 -> Tiger ...
        System.out.println(map.get(5));                    // null
        System.out.println(map.getOrDefault(5, "No data")); // No data
        System.out.println(map.isEmpty());                 // false
        System.out.println(map.keySet());                  // [1, 2, 3, 4]
        System.out.println(map.values());                  // [Slot, Tiger, Mammoth, Squirrel]
        map.merge(2, "Lion", (a, b) -> a + b); // {1=Slot, 2=TigerLion, 3=Mammoth, 4=Squirrel}
        System.out.println(map.put(2, "Tiger"));           // TigerLion
        System.out.println(map.putIfAbsent(5, "Wolf"));    // {1=Slot, 2=Tiger, 3=Mammoth, 4=Squirrel, 5=Wolf}
        System.out.println(map.replace(5, "Dog"));         // Wolf
        map.replaceAll((k, v) -> {
            if (k % 2 == 0) {
                return v + "*";
            }
            return v;
        });                                                // {1=Slot, 2=Tiger*, 3=Mammoth, 4=Squirrel*, 5=Dog}
        System.out.println(map.size());                    // 5
        System.out.println(map);
    }
}
