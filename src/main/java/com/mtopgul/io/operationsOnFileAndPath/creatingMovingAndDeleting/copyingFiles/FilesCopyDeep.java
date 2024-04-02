package com.mtopgul.io.operationsOnFileAndPath.creatingMovingAndDeleting.copyingFiles;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

/**
 * @author muhammed-topgul
 * @since 02/04/2024 09:33
 */
public class FilesCopyDeep {
    public static void main(String[] args) {
        Path src = Paths.get("extras/ch14/deep-copy-src");
        Path tgt = Paths.get("extras/ch14/deep-copy-tgt");

        deepCopyPath(src, tgt);
    }

    private static void deepCopyPath(Path source, Path target) {
        try {
            Files.copy(source, target);
            if (Files.isDirectory(source)) {
                try(Stream<Path> pathStream = Files.list(source)) {
                    pathStream.forEach(path -> deepCopyPath(path, target.resolve(path.getFileName())));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
