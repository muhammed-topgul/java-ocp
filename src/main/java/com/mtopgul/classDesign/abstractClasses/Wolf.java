package com.mtopgul.classDesign.abstractClasses;

/**
 * @author muhammed-topgul
 * @since 07/02/2024 10:14
 */
public class Wolf extends Canine {
    @Override
    public String getSound() {
        return "Wooooooof!";
    }

    public static void main(String[] args) {
        Canine canine = new Wolf();
        canine.bark();
    }
}
