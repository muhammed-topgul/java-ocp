package com.mtopgul.operators.assigningValues;

/**
 * @author muhammed-topgul
 * @since 18/01/2024 23:46
 */
public class CastingValues {
    public static void main(String[] args) {
        {
            int fur = (int) 5;
            int hair = (short) 32768;
            System.out.println(hair);
            String type = (String) "bird";
            short tail = (short) (1 + 32767);
            System.out.println(tail);
            // long feathers = 10(long); // DOES NOT COMPILE}
        }

        {
            // float egg = 2.0 / 9; // DOES NOT COMPILE
            // int tadpole = (int)5 * 2L; // DOES NOT COMPILE
            // short frog = 3 - 2.0; // DOES NOT COMPILE
        }

        {
            // int fish = 1.0; // DOES NOT COMPILE
            // short bird = 1921222; // DOES NOT COMPILE
            // int mammal = 9f; // DOES NOT COMPILE
            // long reptile = 192_301_398_193_810_323; // DOES NOT COMPILE
        }
    }
}
