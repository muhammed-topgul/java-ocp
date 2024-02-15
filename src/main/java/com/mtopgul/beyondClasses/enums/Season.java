package com.mtopgul.beyondClasses.enums;

import com.mtopgul.Util;

/**
 * @author muhammed-topgul
 * @since 15/02/2024 09:15
 */
public enum Season {
    WINTER, SPRING, SUMMER, FALL;

    public static void main(String[] args) {
        {
            Season summer = Season.SUMMER;
            System.out.println(Season.SUMMER);
            System.out.println(summer == Season.SUMMER);
        }

        {
            Util.divide("ordinal()");
            for (var season : Season.values()) {
                System.out.println(season.name() + " " + season.ordinal());
            }
        }

        {
            Util.divide("valueOf()");
            System.out.println(Season.valueOf("SUMMER"));
            // System.out.println(Season.valueOf("fall"));  // java.lang.IllegalArgumentException
        }

        {
            Util.divide("switch");
            Season summer = Season.SUMMER;
            switch (summer) {
                case WINTER -> System.out.println("Get out the sled!");
                case SUMMER -> System.out.println("Time for the pool!");
                default -> System.out.println("Is it summer yet?");
            }
        }
    }
}
