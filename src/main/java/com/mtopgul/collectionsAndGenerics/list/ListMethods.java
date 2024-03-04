package com.mtopgul.collectionsAndGenerics.list;

import java.util.ArrayList;
import java.util.List;

/**
 * @author muhammed-topgul
 * @since 04/03/2024 09:19
 */
public class ListMethods {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("SD");                     // [SD]
        list.add(0, "NY");  // [NY,SD]
        list.set(1, "FL");                  // [NY,FL]
        System.out.println(list.get(0));    // NY
        list.remove("NY");               // [FL]
        list.remove(0);              // []
        list.set(0, "?");                   // IndexOutOfBoundsException
    }
}
