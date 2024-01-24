package com.mtopgul.makingDecision.applyingSwitch.switchExpression;

/**
 * @author muhammed-topgul
 * @since 24/01/2024 09:36
 */
public class TheSwitchExpression {
    public static void main(String[] args) {
        TheSwitchExpression expression = new TheSwitchExpression();
        expression.printDayOfWeek(1);
        expression.printDayOfWeek(3);
        expression.printSeason(5);

    }

    void printDayOfWeek(int day) {
        // After Java 14
        var result = switch (day) {
            case 0 -> "Sunday";
            case 1 -> 2;
            case 2 -> "Tuesday";
            case 3 -> "Wednesday";
            case 4 -> "Thursday";
            case 5 -> "Friday";
            case 6 -> "Saturday";
            default -> "Invalid value";
        };
        System.out.println(result);

        // Before Java 14
        switch (day) {
            case 0:
                result = "Sunday";
                break;
            case 1:
                result = "Monday";
                break;
            case 2:
                result = "Tuesday";
                break;
            case 3:
                result = "Wednesday";
                break;
            case 4:
                result = "Thursday";
                break;
            case 5:
                result = "Friday";
                break;
            case 6:
                result = "Saturday";
                break;
            default:
                result = "Invalid value";
                break;
        }
        System.out.println(result);
    }

    void printSeason(int month) {
        switch (month) {
            case 1, 2, 3 -> System.out.println("Winter");
            case 4, 5, 6 -> System.out.println("Spring");
            case 7, 8, 9 -> System.out.println("Summer");
            case 10, 11, 12 -> System.out.println("Fall");
        }
    }
}
