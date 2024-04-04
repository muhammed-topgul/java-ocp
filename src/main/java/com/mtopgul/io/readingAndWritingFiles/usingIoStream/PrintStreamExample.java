package com.mtopgul.io.readingAndWritingFiles.usingIoStream;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

/**
 * @author muhammed-topgul
 * @since 04/04/2024 11:23
 */
public class PrintStreamExample {
    public static void main(String[] args) throws FileNotFoundException {
        var printStream = new PrintStream(new FileOutputStream("extras/ch14/output.txt"));
        try(printStream) {
            printStream.println(2024);
            printStream.println("line1");
            printStream.println("line2");
        }
    }
}
