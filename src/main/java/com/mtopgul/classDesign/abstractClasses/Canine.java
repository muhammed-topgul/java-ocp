package com.mtopgul.classDesign.abstractClasses;

/**
 * @author muhammed-topgul
 * @since 07/02/2024 10:13
 */
public abstract class Canine {
    public abstract String getSound();

    public void bark() {
        System.out.println(getSound());
    }
}
