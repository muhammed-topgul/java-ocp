package com.mtopgul.coreApis.stringMethods;

/**
 * @author muhammed-topgul
 * @since 30/01/2024 08:00
 */
public class ReplacingValues {
    public static void main(String[] args) {
        System.out.println("abcabc".replace('a', 'A'));
        System.out.println("abcabc".replace("a", "A"));
        System.out.println("abcabc".replace(new StringBuilder("c"), new StringBuffer("CX")));
        System.out.println("abcabc".replaceAll("bc", "BC"));
        System.out.println("abcabc".replaceFirst("c", "C"));
    }
}
