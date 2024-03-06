package com.mtopgul.collectionsAndGenerics.generics.bounding;

import java.util.ArrayList;
import java.util.List;

/**
 * @author muhammed-topgul
 * @since 06/03/2024 15:50
 */
public class UnboundedWildcards {
    public static void printList1(List<Object> list) {
        for (Object o : list) {
            System.out.println(o);
        }
    }

    public static void printList2(List<?> list) {
        for (Object o : list) {
            System.out.println(o);
        }
    }

    public static <T> void printList3(List<T> list) {
        for (Object o : list) {
            System.out.println(o);
        }
    }

    public static void main(String[] args) {
        List<String> keywords = new ArrayList<>();
        keywords.add("Java");
        // printList1(keywords); // DOES NOT COMPILE
        printList2(keywords);
        printList3(keywords);
    }
}
