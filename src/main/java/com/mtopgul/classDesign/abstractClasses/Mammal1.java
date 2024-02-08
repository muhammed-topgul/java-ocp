package com.mtopgul.classDesign.abstractClasses;

/**
 * @author muhammed-topgul
 * @since 08/02/2024 07:31
 */
public abstract class Mammal1 {
    abstract CharSequence chew();

    public Mammal1() {
        System.out.println(chew());
    }
}
