package com.mtopgul.coreApis.stringMethods;

/**
 * @author muhammed-topgul
 * @since 30/01/2024 08:17
 */
public class RemovingWhiteSpace {
    public static void main(String[] args) {
        stripWhiteSpace();

        trimWhiteSpace();

        stripTabChar();

        trimTabChar();

        stripSpecialChar();

        trimSpecialChar();

        trimUnicode();

        stripUnicode();
    }

    private static void stripWhiteSpace() {
        System.out.println("### stripWhiteSpace() ###");
        System.out.println("abc".strip()); //abc
        System.out.println(" abc ".strip()); //abc
        System.out.println(" abc ".strip().length()); //3
    }

    private static void trimWhiteSpace() {
        System.out.println("\n### trimWhiteSpace() ###");
        System.out.println("abc".trim()); //abc
        System.out.println(" abc ".trim()); //abc
        System.out.println(" abc ".trim().length()); //3
    }

    private static void stripTabChar() {
        System.out.println("\n### stripTabChar() ###");
        String text = " abc \t";
        System.out.println(text); // abc 	//
        System.out.println(text.length()); //6
        System.out.println(text.strip()); //abc
        System.out.println(text.strip().length()); //3
    }

    private static void trimTabChar() {
        System.out.println("\n### trimTabChar() ###");
        String text = " abc \t";
        System.out.println(text); // abc 	//
        System.out.println(text.length()); //6
        System.out.println(text.trim()); //abc
        System.out.println(text.trim().length()); //3
    }

    private static void stripSpecialChar() {
        System.out.println("\n### stripSpecialChar() ###");
        String text = "\t   a b c\n \r";
        System.out.println(text); // 	  a b c 	//
        System.out.println(text.length()); //12
        System.out.println(text.strip()); //a b c
        System.out.println(text.strip().length()); //5
    }

    private static void trimSpecialChar() {
        System.out.println("\n### trimSpecialChar() ###");
        String text = "\t   a b c\n \r";
        System.out.println(text); // 	  a b c 	//
        System.out.println(text.length()); //12
        System.out.println(text.trim()); //a b c
        System.out.println(text.trim().length()); //5
    }

    private static void stripUnicode() {
        System.out.println("\n### stripUnicode() ###");
        String content = "\u2000Java\u2000";
        System.out.println(content); // Java //
        System.out.println(content.strip());//Java//
    }

    private static void trimUnicode() {
        System.out.println("\n### trimUnicode() ###");
        String content = "\u2000Java\u2000";
        System.out.println(content); // Java //
        System.out.println(content.trim()); // Java //
    }
}
