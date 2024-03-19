package com.mtopgul.exceptionsAndLocalization.resourceManagement;

/**
 * @author muhammed-topgul
 * @since 19/03/2024 14:40
 */
public class MyFileClass implements AutoCloseable {
    private final int num;

    public MyFileClass(int num) {
        this.num = num;
    }

    @Override
    public void close() {
        System.out.println("Closing: " + num);
    }
}
