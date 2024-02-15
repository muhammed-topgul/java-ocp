package com.mtopgul.beyondClasses.records.declaringConstructors.compactConstructor;

/**
 * @author muhammed-topgul
 * @since 15/02/2024 23:52
 */
public class CraneTest {
    public static void main(String[] args) {
        Crane mommy = new Crane(4, "Crane");
        System.out.println(mommy); // Crane[numberEggs=4, name=CRANE]

        new Crane(-1, "Jimmy"); // java.lang.IllegalArgumentException
    }
}
