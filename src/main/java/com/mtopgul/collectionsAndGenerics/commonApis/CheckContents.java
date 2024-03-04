package com.mtopgul.collectionsAndGenerics.commonApis;

import java.util.ArrayList;
import java.util.Collection;

/**
 * @author muhammed-topgul
 * @since 04/03/2024 07:33
 */
public class CheckContents {
    public static void main(String[] args) {
        Collection<String> birds = new ArrayList<>();
        birds.add("hawk");                         // [hawk]
        System.out.println(birds.contains("hawk")); // true
        System.out.println(birds.contains("robin")); // false
    }
}
