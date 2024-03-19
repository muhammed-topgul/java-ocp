package com.mtopgul.exceptionsAndLocalization.handling;

/**
 * @author muhammed-topgul
 * @since 19/03/2024 14:22
 */
public class ExitProgram {
    public static void main(String[] args) {
        try {
            System.out.println("Inside try");
            System.exit(0);
        } finally {
            System.out.print("Never going to get here"); // Not printed
        }
    }
}
