package com.mtopgul.io.serializingData;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * @author muhammed-topgul
 * @since 04/04/2024 17:11
 */
public class SerializingDataExample03 {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        var gorillas = new ArrayList<Gorilla>();
        gorillas.add(new Gorilla("Grodd", 5, false));
        gorillas.add(new Gorilla("Kong", 8, true));

        File file = new File("extras/ch14/gorilla.data");

        saveToFile(gorillas, file);
        System.out.println(readFromFile(file));
    }

    private static void saveToFile(List<Gorilla> gorillas, File file) throws IOException {
        var out = new ObjectOutputStream(new FileOutputStream(file));
        try (out) {
            for (Gorilla gorilla : gorillas) {
                out.writeObject(gorilla);
            }
        }
    }

    private static List<Gorilla> readFromFile(File file) throws IOException, ClassNotFoundException {
        var gorillas = new ArrayList<Gorilla>();
        var ois = new ObjectInputStream(new FileInputStream(file));
        try (ois) {
            while (true) {
                var object = ois.readObject();
                if (object instanceof Gorilla gorilla) {
                    gorillas.add(gorilla);
                }
            }
        } catch (EOFException e) {
            System.out.println("End of file...");
        }
        return gorillas;
    }
}
