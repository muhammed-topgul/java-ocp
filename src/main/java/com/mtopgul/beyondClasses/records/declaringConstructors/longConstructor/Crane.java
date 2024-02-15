package com.mtopgul.beyondClasses.records.declaringConstructors.longConstructor;

/**
 * @author muhammed-topgul
 * @since 15/02/2024 23:32
 */
public record Crane(int numberEggs, String name) {
    public Crane(int numberEggs, String name) {
        if (numberEggs < 0)
            throw new IllegalArgumentException();
        this.numberEggs = numberEggs;
        this.name = name;
    }
}
