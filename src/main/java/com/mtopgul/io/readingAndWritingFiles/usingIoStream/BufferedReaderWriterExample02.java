package com.mtopgul.io.readingAndWritingFiles.usingIoStream;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author muhammed-topgul
 * @since 04/04/2024 11:02
 */
public class BufferedReaderWriterExample02 {
    public static void main(String[] args) throws IOException {
        File src = new File("extras/ch14/lorem-ipsum.txt");
        File dest = new File("extras/ch14/lorem-ipsum-out.txt");

        appendTextFile(src, dest);
    }

    // Mevcut text'in sonuna ekler
    private static void appendTextFile(File src, File dest) throws IOException {
        var reader = new BufferedReader(new FileReader(src));
        var writer = new BufferedWriter(new FileWriter(dest, true));
        try (reader; writer) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
                writer.write(line);
                writer.newLine();
            }
        }
    }
}
