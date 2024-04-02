package com.mtopgul.io.readingAndWritingFiles.usingIoStream;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * @author muhammed-topgul
 * @since 02/04/2024 16:29
 */
public class FileInputOutputStreamExample02 {
    public static void main(String[] args) throws IOException {
        var fis = new FileInputStream("extras/ch14/source-data.txt");
        var fos = new FileOutputStream("extras/ch14/source-data-out.txt");
        copyStream(fis, fos);
    }

    static void copyStream(InputStream in, OutputStream out) throws IOException {
        int batchSize = 6;
        var buffer = new byte[batchSize];
        int lengthRead;
        while ((lengthRead = in.read(buffer, 0, batchSize)) > 0) {
            System.out.println("Buffer: " + lengthRead);
            out.write(buffer, 0, lengthRead);
            out.flush();
        }
        out.close();
    }
}
