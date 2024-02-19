package com.mtopgul.beyondClasses.polymorphism.overridingVsHiding;

/**
 * @author muhammed-topgul
 * @since 19/02/2024 08:36
 */
public class Kangaroo extends Marsupial {
    protected int age = 4;

    public static boolean isBiped() {
        return true;
    }

    public boolean isBiped1() {
        return true;
    }

    public static void main(String[] args) {
        Kangaroo joey = new Kangaroo();
        Marsupial moey = joey;

        System.out.println(joey.isBiped()); // true
        System.out.println(moey.isBiped()); // false

        System.out.println(joey.isBiped1()); // true
        System.out.println(moey.isBiped1()); // true

        System.out.println(joey.age);     // 4
        System.out.println(moey.age);     // 2
    }
}
