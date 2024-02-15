package com.mtopgul.beyondClasses.implementingInterfaces;

/**
 * @author muhammed-topgul
 * @since 15/02/2024 07:51
 */
public class Skip implements Hop {
    public int skip() {
        return Hop.getJumpHeight1();
    }

    /*
    // DOES NOT COMPILE
    public int getJump() {
        return getJumpHeight1();
    }
     */
}
