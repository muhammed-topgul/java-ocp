package com.mtopgul.io.operationsOnFileAndPath.creatingMovingAndDeleting.copyingFiles;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

/**
 * @author muhammed-topgul
 * @since 02/04/2024 09:38
 */
public class FilesCopyReplaceExisting {
    public static void main(String[] args) throws IOException {
        Path src = Paths.get("extras/ch14/book.txt");
        Path tgt = Paths.get("extras/ch14/movie.txt");
        Path path = Files.copy(src, tgt, StandardCopyOption.REPLACE_EXISTING);
        System.out.println(path);

        // FileAlreadyExistsException: extras\ch14\movie.txt
        Files.copy(src, tgt);
    }
}
