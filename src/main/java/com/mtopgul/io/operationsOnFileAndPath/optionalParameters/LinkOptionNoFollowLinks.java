package com.mtopgul.io.operationsOnFileAndPath.optionalParameters;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @author muhammed-topgul
 * @since 01/04/2024 22:46
 */
public class LinkOptionNoFollowLinks {
    public static void main(String[] args) throws IOException {
        Path newLink = Paths.get("extras/ch14/xml-file/schedule.xml");
        Path target = Path.of("extras/ch14/xml-file/another-schedule.xml");

        Files.createFile(target);

        Files.createSymbolicLink(newLink, target);

        System.out.println("Files.exist(): " + Files.exists(newLink));
        System.out.println("isSymbolicLink(): " + Files.isSymbolicLink(newLink));
        System.out.println("Files.exist(#NOFOLLOW_LINKS): " + Files.exists(newLink, LinkOption.NOFOLLOW_LINKS));
        System.out.printf("Target of link" + "'%s' is '%s'\n", newLink, Files.readSymbolicLink(newLink));
    }
}
