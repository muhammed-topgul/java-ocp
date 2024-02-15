package com.mtopgul.beyondClasses.implementingInterfaces;

/**
 * @author muhammed-topgul
 * @since 15/02/2024 08:05
 */
public interface ZooRenovation {
    public String projectName();

    abstract String status();

    public default void printStatus() {
        System.out.print("The " + projectName() + " project " + status());
    }
}

class Zoo implements ZooRenovation {

    @Override
    public String projectName() {
        return "Zobi";
    }

    @Override
    public String status() {
        return "TODO";
    }

    public static void main(String[] args) {
        new Zoo().printStatus();
    }
}
