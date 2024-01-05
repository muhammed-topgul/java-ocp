package com.mtopgul.buildingBlocks.dataTypes;

/**
 * @author muhammed-topgul
 * @since 05/01/2024 08:45
 */
public class LiteralsAndTheUnderscoreCharacter {
    public static void main(String[] args) {
        // double notAtStart = _1000.00; // DOES NOT COMPILE
        // double notAtEnd = 1000.00_; // DOES NOT COMPILE
        // double notByDecimal = 1000_.00; // DOES NOT COMPILE
        double annoyingButLegal = 1_00_0.0_0; // Ugly, but compiles
        double reallyUgly = 1__________2; // Also compiles
    }
}
