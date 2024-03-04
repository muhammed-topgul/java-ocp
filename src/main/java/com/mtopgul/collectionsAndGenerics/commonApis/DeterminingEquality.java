package com.mtopgul.collectionsAndGenerics.commonApis;

import java.util.List;
import java.util.Set;

/**
 * @author muhammed-topgul
 * @since 04/03/2024 08:31
 */
public class DeterminingEquality {
    public static void main(String[] args) {
        var list1 = List.of(1, 2);
        var list2 = List.of(2, 1);

        var set1 = Set.of(1, 2);
        var set2 = Set.of(2, 1);

        System.out.println(list1.equals(list2)); // false
        System.out.println(set1.equals(set2));   // true
        System.out.println(set1.equals(list1));  // false
    }
}
