package com.mtopgul.io.serializingData;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * @author muhammed-topgul
 * @since 04/04/2024 16:33
 */
public class SerializingDataExample01 {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        File file = new File("extras/ch14/cat.serial");

        var oos = new ObjectOutputStream(new FileOutputStream(file));

        Cat cat = new Cat("Tekir", 2, "Black");

        oos.writeObject(cat);
        oos.close();

        var ois = new ObjectInputStream(new FileInputStream(file));
        Cat deserializedCat = (Cat) ois.readObject();
        System.out.println(deserializedCat);
        ois.close();
    }
}
