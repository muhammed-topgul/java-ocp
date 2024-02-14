package com.mtopgul.beyondClasses.implementingInterfaces;

/**
 * @author muhammed-topgul
 * @since 14/02/2024 09:10
 */
public interface Soar {
    int MAX_HEIGHT = 10;
    final static boolean UNDERWATER = true;

    void fly(int speed);

    abstract void takeoff();

    public abstract double dive();
}

abstract interface Soar1 {
    public static final int MAX_HEIGHT = 10;
    public final static boolean UNDERWATER = true;

    public abstract void fly(int speed);

    public abstract void takeoff();

    double dive();
}
