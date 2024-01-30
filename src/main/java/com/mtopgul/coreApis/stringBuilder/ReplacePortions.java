package com.mtopgul.coreApis.stringBuilder;

/**
 * @author muhammed-topgul
 * @since 30/01/2024 10:28
 */
public class ReplacePortions {
    public static void main(String[] args) {
        replace1();
        replace2();
        replace3();
        replace4();
        replace5();
    }

    private static void replace1() {
        var sb = new StringBuilder("pigeon dirty");
        sb.replace(3, 6, "sty");
        System.out.println(sb);  // pigsty dirty
    }

    private static void replace2() {
        var sb = new StringBuilder("pigeon dirty");
        sb.replace(3, 100, "");
        System.out.println(sb);  // pig
    }

    private static void replace3() {
        var sb = new StringBuilder("pigeon dirty");
        sb.replace(3, 100, "A");
        System.out.println(sb);  // pigA
    }

    private static void replace4() {
        var sb = new StringBuilder("pigeon dirty");
        sb.replace(1, 11, "A");
        System.out.println(sb);  // pAy
    }

    private static void replace5() {
        var sb = new StringBuilder("pigeon dirty");
        sb.replace(4, 8, "A_______A");
        System.out.println(sb);  // pigeA_______Airty
    }
}
