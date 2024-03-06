package com.mtopgul.collectionsAndGenerics.generics.bounding;

import java.util.ArrayList;
import java.util.List;

/**
 * @author muhammed-topgul
 * @since 06/03/2024 16:09
 */
public class EdgeCase {
    public static void main(String[] args) {
        List<? extends Bird> birds = new ArrayList<Bird>();
        // birds.add(new Sparrow()); // DOES NOT COMPILE
        // birds.add(new Bird());    // DOES NOT COMPILE
    }
}

class Bird {}

class Sparrow extends Bird {}


