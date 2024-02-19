package com.mtopgul.beyondClasses.polymorphism.overridingVsHiding;

/**
 * @author muhammed-topgul
 * @since 19/02/2024 08:36
 */
public class Marsupial {
    protected int age = 2;

    public static boolean isBiped() {
        return false;
    }

    public boolean isBiped1() {
        return false;
    }
}
