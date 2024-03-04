package com.mtopgul.collectionsAndGenerics.list;

import java.util.ArrayList;

/**
 * @author muhammed-topgul
 * @since 04/03/2024 09:17
 */
public class VarWithList {
    public static void main(String[] args) {
        var strings = new ArrayList<String>();
        for (String string : strings) {
        }

        var list = new ArrayList<>(); // equal to ArrayList<Object> list = new ArrayList<>();


        list.add("A");
        // for (String s : list) { } // DOES NOT COMPILE
    }
}
