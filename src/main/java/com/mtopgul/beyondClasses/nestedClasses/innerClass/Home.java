package com.mtopgul.beyondClasses.nestedClasses.innerClass;

/**
 * @author muhammed-topgul
 * @since 18/02/2024 23:10
 */
public class Home {
    private String greeting = "Hi";

    protected class Room {
        public int repeat = 3;

        public void enter() {
            for (int i = 0; i < repeat; i++) {
                greet(greeting);
            }
        }

        private static void greet(String message) {
            System.out.println(message);
        }
    }

    public void enterRoom() {
        Room room = new Room();
        room.enter();
    }

    public static void main(String[] args) {
        new Home().enterRoom();
        new Home().new Room().enter();
    }
}
