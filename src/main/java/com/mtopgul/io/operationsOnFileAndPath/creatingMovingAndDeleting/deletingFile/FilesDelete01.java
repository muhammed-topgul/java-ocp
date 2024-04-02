package com.mtopgul.io.operationsOnFileAndPath.creatingMovingAndDeleting.deletingFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * @author muhammed-topgul
 * @since 02/04/2024 13:41
 */
public class FilesDelete01 {
    public static void main(String[] args) throws IOException, InterruptedException {
        // Util.createFile("extras/ch14/vulture", "feathers.xml");

        Files.delete(Path.of("extras/ch14/vulture").resolve(Path.of("feathers.xml")));

        // NoSuchFileException: extras\ch14\vulture\feathers.xml
        Files.delete(Path.of("extras/ch14/vulture").resolve(Path.of("feathers.xml")));
    }
}
