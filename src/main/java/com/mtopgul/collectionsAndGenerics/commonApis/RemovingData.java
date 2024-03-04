package com.mtopgul.collectionsAndGenerics.commonApis;

import java.util.ArrayList;
import java.util.Collection;

/**
 * @author muhammed-topgul
 * @since 04/03/2024 07:25
 */
public class RemovingData {
    public static void main(String[] args) {
        Collection<String> birds = new ArrayList<>();
        birds.add("hawk");
        birds.add("hawk");
        System.out.println(birds.remove("cardinal")); // false
        System.out.println(birds.remove("hawk"));     // true
        System.out.println(birds);                       // [hawk]
    }
}
