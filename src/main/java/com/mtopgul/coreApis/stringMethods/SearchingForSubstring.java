package com.mtopgul.coreApis.stringMethods;

/**
 * @author muhammed-topgul
 * @since 30/01/2024 07:45
 */
public class SearchingForSubstring {
    public static void main(String[] args) {
        System.out.println("abc".startsWith("a")); // true
        System.out.println("abcd".startsWith("c", 2));
        System.out.println("abc".endsWith("A"));   // false

        System.out.println("abc".endsWith("c"));  // true
        System.out.println("abc".endsWith("a"));  // false

        System.out.println("abc".contains("b"));  // true
        System.out.println("abc".contains("bc"));  // true

        System.out.println("abc".contains(new StringBuilder("ab"))); // true
        System.out.println("abc".contains(new StringBuffer("ab"))); // true
    }
}
