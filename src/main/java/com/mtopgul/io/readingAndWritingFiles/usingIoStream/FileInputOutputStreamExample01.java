package com.mtopgul.io.readingAndWritingFiles.usingIoStream;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * @author muhammed-topgul
 * @since 02/04/2024 16:17
 */
public class FileInputOutputStreamExample01 {
    public static void main(String[] args) throws IOException {
        var fis = new FileInputStream("extras/ch14/source-data.txt");
        var fos = new FileOutputStream("extras/ch14/source-data-out.txt");
        copyStream(fis, fos);
    }

    private static void copyStream(InputStream in, OutputStream out) throws IOException {
        int b;
        while ((b = in.read()) != -1) {
            System.out.print((char) b);
            out.write(b);
        }
        out.close();
    }
}
