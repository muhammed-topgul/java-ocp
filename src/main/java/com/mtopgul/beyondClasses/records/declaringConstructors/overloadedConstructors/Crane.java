package com.mtopgul.beyondClasses.records.declaringConstructors.overloadedConstructors;

/**
 * @author muhammed-topgul
 * @since 15/02/2024 23:58
 */
public record Crane(int numberEggs, String name) {
    public Crane(String firstName, String lastName) {
        this(0, firstName, lastName);
    }

    public Crane(int numberEggs, String firstName, String lastName) {
        this(numberEggs, firstName + " " + lastName);
        numberEggs = 10; // NO EFFECT (applies to parameter, not instance field)
        // this.numberEggs = 20; // DOES NOT COMPILE
    }
}
