package com.mtopgul.beyondClasses.polymorphism.castingInterfaces;

/**
 * @author muhammed-topgul
 * @since 19/02/2024 08:18
 */
public class Pars extends Wolf implements Canine {
    public static void main(String[] args) {
        Wolf wolf = new Pars();
        Canine canine = (Canine) wolf;
    }
}
