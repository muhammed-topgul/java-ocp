package com.mtopgul.beyondClasses.implementingInterfaces;

/**
 * @author muhammed-topgul
 * @since 15/02/2024 07:43
 */
public class Cat implements Walk, Run {
    // If a class inherits two or more default methods with the same method signature, then the
    // class must override the method.
    @Override
    public int speed() {
        return 1;
    }

    public int getWalkSpeed() {
        return Walk.super.speed();
    }
}
