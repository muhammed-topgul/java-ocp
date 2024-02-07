package com.mtopgul.classDesign.inheritingMembers;

/**
 * @author muhammed-topgul
 * @since 07/02/2024 10:09
 */
public class Penguin extends Bird {
    /**
     * DOES NOT COMPILE
     * If a method has final keyword. This method cannot override or hide.
     * public boolean hasFeathers() {
     * return true;
     * }
     */

    /**
     * DOES NOT COMPILE
    public static void flyAway() {
        System.out.println("Flw away");
    }
     */
}
