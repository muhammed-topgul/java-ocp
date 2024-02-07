package com.mtopgul.classDesign.inheritingMembers;

import java.io.IOException;

/**
 * @author muhammed-topgul
 * @since 07/02/2024 09:45
 */
public class Bear {
    protected static void eat() throws IOException {
        System.out.println("Bear is eating");
    }

    public static void sneeze() {
        System.out.println("Bear is sneezing");
    }

    public void hibernate() {
        System.out.println("Bear is hibernating");
    }

    public static void laugh() {
        System.out.println("Bear is laughing");
    }
}
