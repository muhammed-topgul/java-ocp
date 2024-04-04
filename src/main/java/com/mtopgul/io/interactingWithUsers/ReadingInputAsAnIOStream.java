package com.mtopgul.io.interactingWithUsers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author muhammed-topgul
 * @since 04/04/2024 17:40
 */
public class ReadingInputAsAnIOStream {
    public static void main(String[] args) throws IOException {
        var reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Print your message: ");
        String input = reader.readLine();

        System.out.println("You entered: " + input);
    }
}
