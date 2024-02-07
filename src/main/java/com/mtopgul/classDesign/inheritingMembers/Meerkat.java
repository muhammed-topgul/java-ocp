package com.mtopgul.classDesign.inheritingMembers;

import sun.misc.Unsafe;

/**
 * @author muhammed-topgul
 * @since 07/02/2024 10:04
 */
public class Meerkat extends Carnivore {
    protected boolean hasFur = false;

    public static void main(String[] args) {
        Meerkat meerkat = new Meerkat();
        Carnivore carnivore = meerkat;

        System.out.println(meerkat.hasFur);   // true
        System.out.println(carnivore.hasFur); // false
    }
}
