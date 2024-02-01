package com.mtopgul.methods.declaringVariables;

/**
 * @author muhammed-topgul
 * @since 01/02/2024 14:31
 */
public class LocalVariableModifier {
    public void zooAnimalCheckup(boolean isWeekend) {
        final int rest;
        if (isWeekend) {
            rest = 5;
        } else {
            rest = 10;
        }

        final var giraffe = new String("Giraffe");
        final int[] friends = new int[5];

        /*
        rest = 10;                           // DOES NOT COMPILE
        giraffe = new String("New giraffe"); // DOES NOT COMPILE
        friends = null;                      // DOES NOT COMPILE
         */
    }
}
