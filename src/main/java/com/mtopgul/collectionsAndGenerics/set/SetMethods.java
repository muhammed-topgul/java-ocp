package com.mtopgul.collectionsAndGenerics.set;

import java.util.Set;
import java.util.TreeSet;

/**
 * @author muhammed-topgul
 * @since 04/03/2024 15:57
 */
public class SetMethods {
    public static void main(String[] args) {
        /*
        Set<Character> letters = Set.of('z', 'o', 'o');  // IllegalArgumentException
        Set<Character> copy = Set.copyOf(letters);
        System.out.println(letters);
        System.out.println(copy);*/

        Set<Integer> set = new TreeSet<>();
        set.add(66);  // true
        set.add(10);  // true
        set.add(66);  // false
        set.add(8);   // true
        set.forEach(System.out::println); // 66 8 10
    }
}
