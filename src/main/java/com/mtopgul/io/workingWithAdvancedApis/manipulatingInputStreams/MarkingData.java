package com.mtopgul.io.workingWithAdvancedApis.manipulatingInputStreams;

import com.mtopgul.Util;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author muhammed-topgul
 * @since 04/04/2024 19:02
 */
public class MarkingData {
    public static void main(String[] args) throws IOException {
        var fis = new FileInputStream("extras/ch14/lion.txt");
        readData(fis);

        Util.divide();
        var bis = new BufferedInputStream(new FileInputStream("extras/ch14/lion.txt"));
        readData(bis);
    }

    private static void readData(InputStream inputStream) throws IOException {
        System.out.print((char) inputStream.read()); // L

        if (inputStream.markSupported()) {
            inputStream.mark(100);
            System.out.print((char) inputStream.read());
            System.out.print((char) inputStream.read());
            inputStream.reset();
        }

        System.out.print((char) inputStream.read()); // I
        System.out.print((char) inputStream.read()); // O
        System.out.print((char) inputStream.read()); // N
    }
}
