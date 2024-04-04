package com.mtopgul.io.readingAndWritingFiles.usingIoStream;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author muhammed-topgul
 * @since 03/04/2024 12:57
 */
public class BufferedInputOutputStreamExample01 {
    public static void main(String[] args) throws IOException {
        File src = new File("extras/ch14/lorem-ipsum.txt");
        File dest = new File("extras/ch14/lorem-ipsum-out.txt");

        copyTextFile(src, dest);
    }

    private static void copyTextFile(File src, File dest) throws IOException {
        var bis = new BufferedInputStream(new FileInputStream(src), 8192);
        var bos = new BufferedOutputStream(new FileOutputStream(dest), 8192);
        try (bis; bos) {
            while (bis.available() > 0) {
                bos.write(bis.read());
            }
        }
    }
}
