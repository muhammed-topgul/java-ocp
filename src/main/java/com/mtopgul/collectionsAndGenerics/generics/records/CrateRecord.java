package com.mtopgul.collectionsAndGenerics.generics.records;

import com.mtopgul.collectionsAndGenerics.generics.interfaces.Robot;

/**
 * @author muhammed-topgul
 * @since 06/03/2024 15:38
 */
public record CrateRecord<T>(T contents) {
    @Override
    public T contents() {
        if (contents == null) {
            throw new IllegalStateException("Missing contents");
        }
        return contents;
    }

    public static void main(String[] args) {
        Robot robot = new Robot();
        CrateRecord<Robot> record = new CrateRecord<>(robot);
    }
}
