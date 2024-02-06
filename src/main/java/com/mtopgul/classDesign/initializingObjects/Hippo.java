package com.mtopgul.classDesign.initializingObjects;

/**
 * @author muhammed-topgul
 * @since 06/02/2024 11:47
 */
public class Hippo extends Animal {
    public static void main(String[] args) {
        System.out.print("C");
        new Hippo();
        new Hippo();
        new Hippo();
    }

    static {
        System.out.print("B");
    }
}
