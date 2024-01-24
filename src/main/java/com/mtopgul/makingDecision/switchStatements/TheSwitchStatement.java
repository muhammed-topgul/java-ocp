package com.mtopgul.makingDecision.switchStatements;

/**
 * @author muhammed-topgul
 * @since 24/01/2024 07:51
 */
public class TheSwitchStatement {
    void printAnimal(int animal) {
        // Before Java 14
        switch (animal) {
            case 1:
            case 2:
                System.out.println("Lion");
            case 3:
                System.out.println("Tiger");
        }

        // After Java 14
        switch (animal) {
            case 1, 2:
                System.out.println("Lion");
            case 3:
                System.out.println("Tiger");
        }

        switch (animal) {
        }
    }

    void acceptableCaseValues() {
        final int bananas = 1;
        int apples = 2;
        int numberOfAnimals = 3;
        final int cookies = getCookies();
        switch (numberOfAnimals) {
            case bananas:
            // case apples:       // DOES NOT COMPILE
            // case getCookies(): // DOES NOT COMPILE
            // case cookies:      // DOES NOT COMPILE
            case 3 * 5:
        }
    }

    final int getCookies() {
        return 4;
    }

    public static void main(String[] args) {

    }
}
