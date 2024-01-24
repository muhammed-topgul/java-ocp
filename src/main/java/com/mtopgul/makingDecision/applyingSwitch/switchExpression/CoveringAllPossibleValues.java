package com.mtopgul.makingDecision.applyingSwitch.switchExpression;

/**
 * @author muhammed-topgul
 * @since 24/01/2024 10:10
 */
public class CoveringAllPossibleValues {
    public static void main(String[] args) {
        int canis = 5;
        String type = switch (canis) {
            case 1 -> "dog";
            case 2 -> "wolf";
            case 3 -> "coyote";
            default -> "Invalid"; // DOES NOT COMPILE without default. Switch expression must cover all possible values
        };
    }

    enum Season {
        WINTER, SPRING, SUMMER, FALL;
    }

    String getWeather(Season value) {
        // Since all possible permutations of Season are covered, a default branch is not required in this switch expression.
        return switch (value) {
            case WINTER -> "Cold";
            case SPRING ->  "Rainy";
            case SUMMER -> "Hot";
            case FALL -> "Warm";
        };
    }
}
