package com.mtopgul.io.interactingWithUsers;

import java.io.Console;
import java.io.PrintWriter;

/**
 * @author muhammed-topgul
 * @since 04/04/2024 18:46
 */
public class ReadingConsoleData {
    public static void main(String[] args) {
        Console console = System.console();
        if (console != null) {
            PrintWriter writer = console.writer();
            writer.println("Console Example");

            writer.println("Username: ");
            String username = console.readLine();

            writer.println("Password: ");
            char[] password = console.readPassword();

            writer.println("The user: " + username);
            writer.println("Password length: " + password.length);
        }
    }
}
