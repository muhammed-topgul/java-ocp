package com.mtopgul.beyondClasses.enums;

/**
 * @author muhammed-topgul
 * @since 15/02/2024 09:36
 */
public enum Season1 {
    WINTER("Low"), SPRING("Medium"), SUMMER("High"), FALL("Medium");
    private final String expectedVisitors;

    private Season1(String expectedVisitors) {
        this.expectedVisitors = expectedVisitors;
    }

    public void printExpectedVisitors() {
        System.out.println(expectedVisitors);
    }
}
