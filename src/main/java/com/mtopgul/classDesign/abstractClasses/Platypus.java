package com.mtopgul.classDesign.abstractClasses;

/**
 * @author muhammed-topgul
 * @since 08/02/2024 07:38
 */
public class Platypus extends Mammal1 {
    @Override
    protected String chew() {
        return "Yummy!";
    }

    public static void main(String[] args) {
        new Platypus();
    }
}
