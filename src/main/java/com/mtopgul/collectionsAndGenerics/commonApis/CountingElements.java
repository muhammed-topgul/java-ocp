package com.mtopgul.collectionsAndGenerics.commonApis;

import java.util.ArrayList;
import java.util.Collection;

/**
 * @author muhammed-topgul
 * @since 04/03/2024 07:28
 */
public class CountingElements {
    public static void main(String[] args) {
        Collection<String> birds = new ArrayList<>();
        System.out.println(birds.isEmpty());  // true
        System.out.println(birds.size());     // 0

        birds.add("hawk");                    // [hawk]
        birds.add("hawk");                    // [hawk, hawk]
        System.out.println(birds.isEmpty());  // false
        System.out.println(birds.size());     // 2
    }
}
