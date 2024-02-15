package com.mtopgul.beyondClasses.records.customizing;

/**
 * @author muhammed-topgul
 * @since 16/02/2024 00:07
 */
public record Crane(int numberEggs, String name) {
    private static int type = 10;
    public static String MESSAGE = "This is a message";
    // public int age;            // DOES NOT COMPILE
    // private boolean friendly;  // DOES NOT COMPILE

    static {
        System.out.println("static initializing block");
    }

    /*
    DOES NOT COMPILE
    Records also do not support instance initializers.
    {
        System.out.println("instance initializing block");
    }
     */

    @Override
    public int numberEggs() {
        return numberEggs * 10;
    }

    @Override
    public String name() {
        return name + "_updated";
    }
}
