package com.mtopgul.coreApis.stringMethods;

/**
 * @author muhammed-topgul
 * @since 26/01/2024 08:41
 */
public class ImportantStringMethods {
    public static void main(String[] args) {
        var name = "animals";

        System.out.println(name.length());

        System.out.println(name.charAt(0)); // a
        System.out.println(name.charAt(6)); // s
        // System.out.println(name.charAt(7)); // s java.lang.StringIndexOutOfBoundsException: String index out of range: 7

        System.out.println(name.indexOf('a'));  // 0
        System.out.println(name.indexOf('a', 4));  // 4
        System.out.println(name.indexOf("al")); // 4
        System.out.println(name.indexOf("al", 5)); // -1

        System.out.println(name.substring(3));      // mals
        System.out.println(name.substring(name.indexOf('m'))); // mals
        System.out.println(name.substring(3, 5));              // ma
        System.out.println(name.substring(3, 7));              // ma

        System.out.println(name.substring(3, 3));              // empty string
        // System.out.println(name.substring(3, 2));              // java.lang.StringIndexOutOfBoundsException: begin 3, end 2, length 7
        System.out.println(name.substring(3, 8));              // java.lang.StringIndexOutOfBoundsException: begin 3, end 8, length 7
    }
}
