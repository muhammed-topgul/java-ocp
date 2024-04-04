package com.mtopgul.io.serializingData;

import java.io.Serializable;

/**
 * @author muhammed-topgul
 * @since 04/04/2024 16:41
 */
public class Collar implements Serializable {
    private int collarSize;

    public Collar(int collarSize) {
        this.collarSize = collarSize;
    }

    public int getCollarSize() {
        return collarSize;
    }

    @Override
    public String toString() {
        return "Collar{" +
                "collarSize=" + collarSize +
                '}';
    }
}
