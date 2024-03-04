package com.mtopgul.collectionsAndGenerics.list;

import java.util.ArrayList;
import java.util.List;

/**
 * @author muhammed-topgul
 * @since 04/03/2024 15:32
 */
public class ListToArray {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("hawk");
        list.add("robin");
        Object[] objectArray = list.toArray();
        String[] stringArray = list.toArray(new String[0]);
        list.clear();
        System.out.println(objectArray.length); // 2
        System.out.println(stringArray.length); // 2
    }
}
