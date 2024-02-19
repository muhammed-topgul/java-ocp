package com.mtopgul.beyondClasses.polymorphism;

/**
 * @author muhammed-topgul
 * @since 19/02/2024 07:44
 */
public class Lemur extends Primate implements HasTail {
    @Override
    public boolean isTailStripped() {
        return false;
    }

    public int age = 10;

    public static void main(String[] args) {
        Lemur lemur = new Lemur();
        System.out.println(lemur.age);

        HasTail hasTail = lemur;
        System.out.println(hasTail.isTailStripped());

        Primate primate = lemur;
        System.out.println(primate.hasHair());
    }
}
