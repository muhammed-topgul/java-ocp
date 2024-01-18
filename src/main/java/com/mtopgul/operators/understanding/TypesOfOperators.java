package com.mtopgul.operators.understanding;

/**
 * @author muhammed-topgul
 * @since 18/01/2024 22:29
 */
public class TypesOfOperators {
    public static void main(String[] args) {
        int cookies = 4;
        // Evaluated left to right
        double reward = 3 + 2 * --cookies;
        System.out.println(reward); // 9.0
    }
}
