package com.mtopgul.coreApis.mathApi;

/**
 * @author muhammed-topgul
 * @since 29/01/2024 09:07
 */
public class MathApi {
    public static void main(String[] args) {
        // Round
        {
            System.out.println(Math.round(123.45));  // 123
            System.out.println(Math.round(123.5));   // 124
            System.out.println(Math.round(123.45F)); // 123
        }

        // Ceil and Round
        {
            System.out.println(Math.ceil(3.14));  // 4.0
            System.out.println(Math.floor(3.14)); // 3.0
        }
    }
}
