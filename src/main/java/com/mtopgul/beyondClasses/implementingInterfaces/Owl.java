package com.mtopgul.beyondClasses.implementingInterfaces;

/**
 * @author muhammed-topgul
 * @since 14/02/2024 08:58
 */
public class Owl implements HasBigEyes {
    @Override
    public void flap() {
        System.out.println("Flapping");
    }

    @Override
    public int hunt() {
        return 1;
    }

    @Override
    public void printDetail() {
        System.out.println("It has big eyes.");
    }

    @Override
    public int eyeCount() {
        return 2;
    }
}
