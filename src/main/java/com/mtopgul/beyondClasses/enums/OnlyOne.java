package com.mtopgul.beyondClasses.enums;

/**
 * @author muhammed-topgul
 * @since 15/02/2024 09:32
 */
public enum OnlyOne {
    TRUE(true), FALSE(false);

    OnlyOne(boolean b) {
        System.out.println(b);
    }
}
