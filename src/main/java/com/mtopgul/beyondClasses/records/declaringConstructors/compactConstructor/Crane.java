package com.mtopgul.beyondClasses.records.declaringConstructors.compactConstructor;

/**
 * @author muhammed-topgul
 * @since 15/02/2024 23:52
 */
public record Crane(int numberEggs, String name) {
    public Crane {
        if (numberEggs < 0)
            throw new IllegalArgumentException();
        // Compact constructors can modify the constructor parameters, they cannot modify the fields of the record
        // this.numberEggs = 10;
        name = name.toUpperCase();
    }
}
