package com.mtopgul.collectionsAndGenerics.generics.bounding;

import java.util.ArrayList;
import java.util.List;

/**
 * @author muhammed-topgul
 * @since 06/03/2024 15:54
 */
public class UpperBoundedWildcards {
    public static void main(String[] args) {
        // ArrayList<Number> list = new ArrayList<Integer>(); // DOES NOT COMPILE
        ArrayList<? extends Number> list = new ArrayList<Integer>();
    }

    private static <T extends Number> List<T> print(List<T> list) {
        System.out.println(list);
        return list;
    }
}
