package com.mtopgul.classDesign.abstractClasses;

/**
 * @author muhammed-topgul
 * @since 08/02/2024 07:35
 */
public class Lion extends BigCat {
    @Override
    String getName() {
        return "Lion.getName()";
    }

    @Override
    protected void roar() {
        System.out.println("Lion.roar()");
    }
}
