package com.mtopgul.buildingBlocks.packagesAndImports;

import java.util.Random;
import java.util.*;       // Redundant
import java.lang.*;       // Redundant
import java.lang.System;  // Redundant

/**
 * @author muhammed-topgul
 * @since 04/01/2024 08:55
 */
public class NumberPicker {
    public static void main(String[] args) {
        Random random = new Random();
        System.out.println(random.nextInt(10));
    }
}
