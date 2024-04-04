package com.mtopgul.io.serializingData;

import com.mtopgul.Util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * @author muhammed-topgul
 * @since 04/04/2024 16:43
 */
public class SerializingDataExample02 {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Collar collar = new Collar(3);
        Dog dog = new Dog(collar, 8);

        Util.divide("Before Serialization", 0);
        System.out.println(dog);

        File file = new File("extras/ch14/dog.serial");
        var oos = new ObjectOutputStream(new FileOutputStream(file));
        oos.writeObject(dog);
        oos.close();

        var ois = new ObjectInputStream(new FileInputStream(file));
        Dog deserializedDog = (Dog) ois.readObject();

        Util.divide("After Serialization");
        System.out.println(deserializedDog);
    }
}
