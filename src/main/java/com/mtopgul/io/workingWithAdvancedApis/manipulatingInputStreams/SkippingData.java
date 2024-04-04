package com.mtopgul.io.workingWithAdvancedApis.manipulatingInputStreams;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author muhammed-topgul
 * @since 04/04/2024 19:09
 */
public class SkippingData {
    public static void main(String[] args) throws IOException {
        var bis = new BufferedInputStream(new FileInputStream("extras/ch14/tigers.txt"));
        readData(bis);
    }

    private static void readData(InputStream inputStream) throws IOException {
        System.out.print((char) inputStream.read()); // T

        inputStream.skip(2); // Skips I and G

        inputStream.read();     // Reads E but does not print

        System.out.print((char) inputStream.read()); // R
        System.out.print((char) inputStream.read()); // S
    }
}
