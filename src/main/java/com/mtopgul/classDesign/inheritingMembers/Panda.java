package com.mtopgul.classDesign.inheritingMembers;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

/**
 * @author muhammed-topgul
 * @since 07/02/2024 09:46
 */
public class Panda extends Bear {
    /**
     * DOES NOT COMPILE
     * Weaker access privileges
    static void eat() {
        System.out.println("Panda is chewing");
    }
     */

    /**
     * Method check exception'u genişeletemez veya yenisini tanımlayamaz
    public static void eat() throws Exception {
        System.out.println("Panda is chewing");
    }

     public static void eat() throws SQLException {
        System.out.println("Panda is chewing");
     }
    */

    /**
     * Method hiding de child sınıfta'ki method da static olmalıdır
    public void eat() {
        System.out.println("Panda is chewing");
    }
     */

    public static void eat() throws NullPointerException {
        System.out.println("Panda is chewing");
    }

    // public void sneeze() {} // DOES NOT COMPILE

    // public static void hibernate() {} // DOES NOT COMPILE

    /**
     * DOES NOT COMPILE
    protected static void laugh() {
        System.out.println("Bear is laughing");
    }
     */

    public static void main(String[] args) throws IOException {
        eat();      // Panda is chewing
        Bear bear = new Bear();
        bear.eat(); // Bear is eating

        Bear bear1 = new Panda();
        bear1.eat(); // Bear is eating

        Panda panda = new Panda();
        panda.eat(); // Panda is chewing
    }
}
