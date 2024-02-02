package com.mtopgul.methods.accessingStaticData;

/**
 * @author muhammed-topgul
 * @since 02/02/2024 11:06
 */
public class Gorilla {
    public static int count;

    public static void addGorilla() {
        count++;
    }

    public void babyGorilla() {
        count++;
    }

    public void announceBabies() {
        addGorilla();
        babyGorilla();
    }

    public static void announceBabiesToEveryone() {
        addGorilla();
        // babyGorilla(); // DOES NOT COMPILE
    }

    public int total;
    // public static double average = total / count; // DOES NOT COMPILE
}
