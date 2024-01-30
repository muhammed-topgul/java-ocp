package com.mtopgul.coreApis.stringMethods;

/**
 * @author muhammed-topgul
 * @since 30/01/2024 08:09
 */
public class GetChars {
    public static void main(String[] args) {
        String content = "mtopgul.com.tr";
        char[] chars = new char[4];
        content.getChars(4, 7, chars, 1);
        System.out.println(chars);
    }
}
