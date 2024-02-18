package com.mtopgul.beyondClasses.nestedClasses.innerClass;

/**
 * @author muhammed-topgul
 * @since 18/02/2024 23:27
 */
public class Fox {
    private class Den {
    }

    public void goHome() {
        new Den();
    }

    public static void visitFriend() {
        // new Den(); // DOES NOT COMPILE
        new Fox().new Den();
    }
}
