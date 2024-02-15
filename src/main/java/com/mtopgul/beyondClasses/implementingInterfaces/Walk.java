package com.mtopgul.beyondClasses.implementingInterfaces;

/**
 * @author muhammed-topgul
 * @since 15/02/2024 07:42
 */
public interface Walk {
    public default int speed() {
        return 5;
    }
}
