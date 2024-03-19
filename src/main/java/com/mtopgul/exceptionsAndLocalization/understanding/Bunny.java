package com.mtopgul.exceptionsAndLocalization.understanding;

/**
 * @author muhammed-topgul
 * @since 19/03/2024 13:26
 */
public class Bunny extends Hopper {
    public static void main(String[] args) {
        // eatCarrot(); // DOES NOT COMPILE

        /*
        try {
            eatCarrot1();
        } catch (NoMoreCarrotsException e) {  // DOES NOT COMPILE
            System.out.println("sad rabbit");
        }*/
    }

    private static void eatCarrot() throws NoMoreCarrotsException {
    }

    private static void eatCarrot1() {
    }

    @Override
    public void hop1() /* throws NoMoreCarrotsException // DOES NOT COMPILE */ {
    }

    @Override
    public void hop2() { // This is fine
    }
}
