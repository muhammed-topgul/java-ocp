package com.mtopgul.collectionsAndGenerics.commonApis;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;

/**
 * @author muhammed-topgul
 * @since 04/03/2024 07:34
 */
public class RemovingWithConditions {
    public static void main(String[] args) {
        Collection<String> list = new ArrayList<>();
        list.add("Magician");
        list.add("Assistant");
        System.out.println(list);  // [Magician, Assistant]
        list.removeIf(s -> s.startsWith("A"));
        System.out.println(list);  // [Magician]

        Collection<String> set = new HashSet<>();
        set.add("Wand");
        set.add("");
        set.removeIf(String::isEmpty);  // s -> s.isEmpty()
        System.out.println(set);        // [Wand]
    }
}
