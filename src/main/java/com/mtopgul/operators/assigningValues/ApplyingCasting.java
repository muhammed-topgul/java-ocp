package com.mtopgul.operators.assigningValues;

/**
 * @author muhammed-topgul
 * @since 18/01/2024 23:56
 */
public class ApplyingCasting {
    public static void main(String[] args) {
        {
            short mouse = 10;
            short hamster = 3;
            // short capybara = mouse * hamster; // DOES NOT COMPILE
            short capybara = (short) (mouse * hamster); // DOES NOT COMPILE
        }
        {
            short capybara = 10 * 3;
        }
    }
}
