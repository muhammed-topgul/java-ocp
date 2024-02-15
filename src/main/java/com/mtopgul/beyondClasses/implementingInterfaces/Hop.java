package com.mtopgul.beyondClasses.implementingInterfaces;

/**
 * @author muhammed-topgul
 * @since 15/02/2024 07:49
 */
public interface Hop {
    /**
     Static Interface Method Definition Rules
     1. A static method must be marked with the static keyword and include a method body.
     2. A static method without an access modifier is implicitly public.
     3. A static method cannot be marked abstract or final.
     4. A static method is not inherited and cannot be accessed in a class implementing the
        interface without a reference to the interface name.
     */

    // RULE #1
    public static int getJumpHeight1() {
        return 8;
    }

    // RULE #2
    static int getJumpHeight2() {
        return 8;
    }

    private static int getJumpHeight3() {
        return 8;
    }
}
