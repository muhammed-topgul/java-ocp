package com.mtopgul.io.readingAndWritingFiles.usingIoStream;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author muhammed-topgul
 * @since 04/04/2024 11:17
 */
public class BufferedReaderPrintWriterExample {
    public static void main(String[] args) throws IOException {
        File src = new File("extras/ch14/lorem-ipsum.txt");
        File dest = new File("extras/ch14/lorem-ipsum-out.txt");

        copyTextFile(src, dest);
    }

    private static void copyTextFile(File src, File dest) throws IOException {
        var reader = new BufferedReader(new FileReader(src));
        var writer = new PrintWriter(new FileWriter(dest));
        try(reader; writer) {
            String line;
            while ((line = reader.readLine()) != null) {
                writer.println(line);
            }
        }
    }
}
