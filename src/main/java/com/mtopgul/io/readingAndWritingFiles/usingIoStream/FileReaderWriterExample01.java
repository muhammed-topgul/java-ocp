package com.mtopgul.io.readingAndWritingFiles.usingIoStream;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;

/**
 * @author muhammed-topgul
 * @since 02/04/2024 16:25
 */
public class FileReaderWriterExample01 {
    public static void main(String[] args) throws IOException {
        var fileReader = new FileReader("extras/ch14/source-data.txt");
        var fileWriter = new FileWriter("extras/ch14/source-data-out.txt");
        copyStream(fileReader, fileWriter);
    }

    private static void copyStream(Reader in, Writer out) throws IOException {
        int b;
        while ((b = in.read()) != -1) {
            System.out.print((char) b);
            out.write(b);
        }
        out.close();
    }
}
