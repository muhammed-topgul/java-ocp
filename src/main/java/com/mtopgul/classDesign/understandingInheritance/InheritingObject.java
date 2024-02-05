package com.mtopgul.classDesign.understandingInheritance;

import java.util.ArrayList;
import java.util.List;

/**
 * @author muhammed-topgul
 * @since 05/02/2024 07:30
 */
public class InheritingObject {
    public static void main(String[] args) {
        String s = "str";
        Integer i = 10;
        BigCat bigCat = new BigCat();
        int[] array = new int[5];
        List<String> list = new ArrayList<>();

        System.out.println(s instanceof Object);
        System.out.println(i instanceof Object);
        System.out.println(bigCat instanceof Object);
        System.out.println(array instanceof Object);
        System.out.println(list instanceof Object);
    }
}
