package com.mtopgul.beyondClasses.records.declaringConstructors.longConstructor;

/**
 * @author muhammed-topgul
 * @since 15/02/2024 23:48
 */
public record Crane1(int numberEggs, String name) implements Bird {
    // public Crane1(int numberEggs, String name) {} // DOES NOT COMPILE

    @Override
    public void printName() {
        System.out.println("I am a Crane");
    }
}
