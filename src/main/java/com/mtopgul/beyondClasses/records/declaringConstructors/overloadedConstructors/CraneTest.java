package com.mtopgul.beyondClasses.records.declaringConstructors.overloadedConstructors;

/**
 * @author muhammed-topgul
 * @since 16/02/2024 00:05
 */
public class CraneTest {
    public static void main(String[] args) {
        Crane mommy = new Crane(4, "Crane");
        System.out.println(mommy);
        System.out.println(mommy.name());
    }
}
