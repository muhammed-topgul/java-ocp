package com.mtopgul.beyondClasses.implementingInterfaces;

/**
 * @author muhammed-topgul
 * @since 15/02/2024 08:00
 */
public interface Schedule {
    default void wakeUp() {
        checkTime(7);
    }

    private void haveBreakFast() {
        checkTime(9);
    }

    static void workOut() {
        checkTime(18);
    }

    private static void checkTime(int hour) {
        if (hour > 17) {
            System.out.println("You're late!");
        } else {
            System.out.println("You have " + (17 - hour) + " hours left " + "to make the appointment");
        }
    }
}
