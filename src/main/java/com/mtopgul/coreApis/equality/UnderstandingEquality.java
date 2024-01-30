package com.mtopgul.coreApis.equality;

/**
 * @author muhammed-topgul
 * @since 30/01/2024 11:12
 */
public class UnderstandingEquality {
    public static void main(String[] args) {
        var one = new StringBuilder();
        var two = new StringBuilder();
        var three = one.append("a");

        System.out.println(one == two);         // false
        System.out.println(one == three);       // true
        System.out.println(one.equals(three));  // true
        System.out.println(one.equals(two));    // false

        var name = "Muhammed";
        var builder = new StringBuilder("Muhammed");
        // System.out.println(name == builder);              // DOES NOT COMPILE
        System.out.println(name.equals(builder));            // false
        System.out.println(name.equals(builder.toString())); // true
        System.out.println(name.contentEquals(builder));     // true
    }
}
