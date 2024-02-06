package com.mtopgul.classDesign.initializingObjects;

/**
 * @author muhammed-topgul
 * @since 06/02/2024 11:52
 */
public class MouseHouse {
    private final String name = "The Mouse House";
    private final int volume;
    private final int age;

    {
        volume = 10;
    }

    public MouseHouse() {
        age = 20;
    }

    public static void main(String[] args) {
        MouseHouse mouseHouse = new MouseHouse();
        System.out.println(mouseHouse.name);
        System.out.println(mouseHouse.volume);
        System.out.println(mouseHouse.age);
    }
}
