package com.mtopgul.io.operationsOnFileAndPath.creatingMovingAndDeleting.comparingFiles;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * @author muhammed-topgul
 * @since 02/04/2024 14:12
 */
public class FilesIsSameFile01 {
    public static void main(String[] args) throws IOException {
        Path p1 = Path.of("/non-exists/missing-file.xml");
        Path p2 = Path.of("/non-exists/missing-file.xml");

        // equals() methodu için path'in olup olmaması önemli değil
        // Eğer equals() true ise isSameFile true döner
        System.out.println(p1.equals(p2));             // true
        System.out.println(Files.isSameFile(p1, p2));  // true

        Path p3 = Path.of("/non-exists/missing-file1.xml");

        // equals() false olursa dosyaların olup olmadığını kontrol eder
        System.out.println(p3.equals(p2));             // false

        // NoSuchFileException: \non-exists\missing-file1.xml
        System.out.println(Files.isSameFile(p3, p2));
    }
}
