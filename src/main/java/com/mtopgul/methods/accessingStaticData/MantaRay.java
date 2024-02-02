package com.mtopgul.methods.accessingStaticData;

/**
 * @author muhammed-topgul
 * @since 02/02/2024 11:00
 */
public class MantaRay {
    private String name;

    public static void first() {
        System.out.println("first()");
    }

    public static void second() {
        System.out.println("second()");
    }

    public void third() {
        System.out.println(name);
    }

    public static void main(String[] args) {
        first();
        second();
        new MantaRay().third();
    }
}
