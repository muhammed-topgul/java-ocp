package com.mtopgul.buildingBlocks.creatingObjects;

/**
 * @author muhammed-topgul
 * @since 05/01/2024 07:35
 */
public class Bird {
    String name = "A";

    {
        name = "B";
        System.out.println("Instance initializer");
    }

    public Bird() {
        name = "C";
        System.out.println("Constructor");
    }

    public static void main(String[] args) {
        {
            System.out.println("Feathers");
        }
        Bird bird = new Bird();
        System.out.println(bird.name);
    }
}
