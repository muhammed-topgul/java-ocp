package com.mtopgul.collectionsAndGenerics.list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author muhammed-topgul
 * @since 04/03/2024 09:19
 */
public class ListMethods {
    public static void main(String[] args) {
        overloadedRemoveMethods();

        List<String> list = new ArrayList<>();
        // list.remove(100);                // IndexOutOfBoundsException
        list.add("SD");                     // [SD]
        list.add(0, "NY");  // [NY,SD]
        list.set(1, "FL");                  // [NY,FL]
        System.out.println(list.get(0));    // NY
        list.remove("NY");               // [FL]
        list.remove(0);              // []
        list.set(0, "?");                   // IndexOutOfBoundsException

        var numbers = Arrays.asList(1, 2, 3);
        numbers.replaceAll(x -> x * 2);
    }

    private static void overloadedRemoveMethods() {
        var list = new LinkedList<Integer>();
        list.add(3);
        list.add(2);
        list.add(1);
        // list.remove();
        list.remove(2);
        list.remove(Integer.valueOf(2));
        System.out.println(list);
    }
}
