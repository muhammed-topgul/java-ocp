package com.mtopgul.beyondClasses.records.understandingEncapsulation;

/**
 * @author muhammed-topgul
 * @since 15/02/2024 23:10
 */
public class Crane {
    private int numberOfEggs;
    private String name;

    public Crane(int numberOfEggs, String name) {
        if (numberOfEggs <= 0)
            throw new IllegalArgumentException();
        this.numberOfEggs = numberOfEggs;
        this.name = name;
    }

    public int getNumberOfEggs() {
        return numberOfEggs;
    }

    public String getName() {
        return name;
    }
}
