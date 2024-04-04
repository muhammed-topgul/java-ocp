package com.mtopgul.io.interactingWithUsers;

import java.io.Console;

/**
 * @author muhammed-topgul
 * @since 04/04/2024 17:50
 */
public class AcquiringInputWithConsole {
    public static void main(String[] args) {
        Console console = System.console();

        if (console != null) {
            System.out.print("Message: ");
            String input = console.readLine();
            console.writer().println("You entered: " + input);
        } else {
            System.err.println("Console not available");
        }
    }
}
