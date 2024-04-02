package com.mtopgul.io.operationsOnFileAndPath.creatingMovingAndDeleting.deletingFile;

import com.mtopgul.Util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * @author muhammed-topgul
 * @since 02/04/2024 13:41
 */
public class FilesDelete03 {
    public static void main(String[] args) throws IOException, InterruptedException {
        // Path dir = Util.createDir("extras/ch14/text-folder1");
        // Util.createFile(dir.resolve("file1.txt"));
        // Util.createFile(dir.resolve("file2.txt"));

        // DirectoryNotEmptyException: extras\ch14\text-folder
        Files.delete(Path.of("extras/ch14/text-folder"));

        // DirectoryNotEmptyException: extras\ch14\text-folder
        Files.deleteIfExists(Path.of("extras/ch14/text-folder"));
    }
}
