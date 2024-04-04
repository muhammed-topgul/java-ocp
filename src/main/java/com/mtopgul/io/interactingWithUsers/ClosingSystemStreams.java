package com.mtopgul.io.interactingWithUsers;

/**
 * @author muhammed-topgul
 * @since 04/04/2024 17:46
 */
public class ClosingSystemStreams {
    public static void main(String[] args) {
        try (var out = System.out) {
        }
        System.out.println("Hello");

        try (var err = System.err) {
        }
        System.err.println("World");
    }
}
