package com.mtopgul.exceptionsAndLocalization.resourceManagement;

/**
 * @author muhammed-topgul
 * @since 19/03/2024 14:47
 */
public class EffectivelyFinal {
    public static void main(String[] args) {
        final var bookReader = new MyFileClass(4);
        MyFileClass movieReader = new MyFileClass(5);
        try (bookReader; movieReader; var tvReader = new MyFileClass(6)) {
            System.out.println("Try Block");
        } finally {
            System.out.println("Finally block");
        }
    }
}
