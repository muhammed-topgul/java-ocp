package com.mtopgul.methods.accessingStaticData;

import java.util.Arrays;
// import static java.util.Arrays;  // DOES NOT COMPILE

import static java.util.Arrays.asList;
import static java.util.Arrays.*;
// static import java.util.Arrays.asList;  // DOES NOT COMPILE

/**
 * @author muhammed-topgul
 * @since 02/02/2024 11:36
 */
public class ZooParking {
    public static void main(String[] args) {
        System.out.println(Arrays.asList("one", "two"));
        System.out.println(asList("three", "four"));
    }
}
