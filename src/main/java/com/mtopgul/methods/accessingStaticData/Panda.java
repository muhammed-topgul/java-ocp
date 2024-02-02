package com.mtopgul.methods.accessingStaticData;

/**
 * @author muhammed-topgul
 * @since 02/02/2024 11:15
 */
public class Panda {
    final static String name = "Ronda";
    static final int bamboo;
    // static final double height;  // DOES NOT COMPILE

    static {
        bamboo = 5;
    }
}
