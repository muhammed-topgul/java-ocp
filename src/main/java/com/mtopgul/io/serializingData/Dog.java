package com.mtopgul.io.serializingData;

import java.io.Serializable;

/**
 * @author muhammed-topgul
 * @since 04/04/2024 16:42
 */
public class Dog implements Serializable {
    private transient Collar collar;
    private int dogSize;

    public Dog(Collar collar, int dogSize) {
        this.collar = collar;
        this.dogSize = dogSize;
    }

    public Collar getCollar() {
        return collar;
    }

    public int getDogSize() {
        return dogSize;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "collar=" + collar +
                ", dogSize=" + dogSize +
                '}';
    }
}
