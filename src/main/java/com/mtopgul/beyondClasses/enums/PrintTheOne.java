package com.mtopgul.beyondClasses.enums;

import com.mtopgul.Util;

/**
 * @author muhammed-topgul
 * @since 15/02/2024 09:33
 */
public class PrintTheOne {
    public static void main(String[] args) {
        System.out.println("begin");
        OnlyOne firstCall = OnlyOne.TRUE;   // Prints constructing
        OnlyOne secondCall = OnlyOne.FALSE; // Prints constructing
        OnlyOne thirdCall = OnlyOne.TRUE;   // Does not print constructing
        System.out.println("end");

        Util.divide();
        Season1.SUMMER.printExpectedVisitors();
    }
}
