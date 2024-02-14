package com.mtopgul.beyondClasses.implementingInterfaces;

/**
 * @author muhammed-topgul
 * @since 14/02/2024 09:03
 */
public class Swan extends Bird implements Swim{
    @Override
    int getType() {
        return 0;
    }

    @Override
    boolean canSwoop() {
        return false;
    }

    @Override
    public void fly() {

    }

    @Override
    public void swim() {

    }
}
