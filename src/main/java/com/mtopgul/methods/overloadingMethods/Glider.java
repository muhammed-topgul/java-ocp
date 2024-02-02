package com.mtopgul.methods.overloadingMethods;

/**
 * @author muhammed-topgul
 * @since 02/02/2024 15:56
 */
public class Glider {
    public static String glide(int i) {
        return "int";
    }

    public static String glide(long i) {
        return "long";
    }

    public static String glide(Integer i) {
        return "Integer";
    }

    public static String glide(Object i) {
        return "Object";
    }

    public static String glide(int... nums) {
        return "varargs";
    }

    public static void main(String[] args) {
        System.out.println(glide(1));
    }
}
