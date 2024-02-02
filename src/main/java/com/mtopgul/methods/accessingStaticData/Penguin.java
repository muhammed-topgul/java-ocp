package com.mtopgul.methods.accessingStaticData;

/**
 * @author muhammed-topgul
 * @since 02/02/2024 10:29
 */
public class Penguin {
    String name;
    static String nameOfTallestPenguin;

    public static void main(String[] args) {
        Penguin p1 = new Penguin();
        p1.name = "Lilly";
        p1.nameOfTallestPenguin = "Lilly";

        Penguin p2 = new Penguin();
        p2.name = "Willy";
        p2.nameOfTallestPenguin = "Willy";

        System.out.println(p1.name);                  // Lilly
        System.out.println(p1.nameOfTallestPenguin);  // Willy

        System.out.println(p2.name);                  // Willy
        System.out.println(p2.nameOfTallestPenguin);  // Willy
    }
}
