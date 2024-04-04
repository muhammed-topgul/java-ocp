package com.mtopgul.io.workingWithAdvancedApis.discoveringFileAttributes;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributeView;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;

/**
 * @author muhammed-topgul
 * @since 04/04/2024 23:21
 */
public class ModifyAttributes {
    public static void main(String[] args) throws IOException {
        var path = Paths.get("extras/ch14/zoo.txt");
        BasicFileAttributeView view = Files.getFileAttributeView(path, BasicFileAttributeView.class);
        BasicFileAttributes attributes = view.readAttributes();

        System.out.println(attributes.lastModifiedTime());

        FileTime lastModifiedTime = FileTime.fromMillis(attributes.lastModifiedTime().toMillis() + 10_000);
        view.setTimes(lastModifiedTime, null, null);

        view = Files.getFileAttributeView(path, BasicFileAttributeView.class);
        attributes = view.readAttributes();
        System.out.println(attributes.lastModifiedTime());
    }
}
