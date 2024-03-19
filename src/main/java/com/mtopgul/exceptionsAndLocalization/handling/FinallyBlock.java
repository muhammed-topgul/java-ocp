package com.mtopgul.exceptionsAndLocalization.handling;

/**
 * @author muhammed-topgul
 * @since 19/03/2024 14:20
 */
public class FinallyBlock {
    public static void main(String[] args) {
        System.out.println(goHome()); // 3
    }
    private static int goHome() {
        try {
            // Optionally throw an exception here
            System.out.print("1");
            return -1;
        } catch (Exception e) {
            System.out.print("2");
            return -2;
        } finally {
            System.out.print("3");
            return -3;
        }
    }
}
