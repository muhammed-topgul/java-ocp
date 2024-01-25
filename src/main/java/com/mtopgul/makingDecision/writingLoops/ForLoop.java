package com.mtopgul.makingDecision.writingLoops;

/**
 * @author muhammed-topgul
 * @since 25/01/2024 07:40
 */
public class ForLoop {
    public static void main(String[] args) {
        {
            for (int i = 0; i < 5; i++)
                System.out.println("Value is: " + i);

            for (var i = 0; i < 5; i++)
                System.out.println("Value is: " + i);

            int i = 0;
            for (; i < 5; i++)
                System.out.println("Value is: " + i);

            for (i = 0; i < 5; i++)
                System.out.println("Value is: " + i);

            int x = 0;
            for (long y = 0, z = 4; x < 5 && y < 10; x++, y++) {
                System.out.print(y + " ");
            }
            System.out.print(x + " ");
        }

        {
            int x = 0;
            for (long y = 0, z = 4; x < 5; x++) // DOES NOT COMPILE
                System.out.print(y + " ");
        }
    }
}
