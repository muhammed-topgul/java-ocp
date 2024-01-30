package com.mtopgul.coreApis.stringMethods;

/**
 * @author muhammed-topgul
 * @since 30/01/2024 09:57
 */
public class FormattingValuesWithFlag {
    public static void main(String[] args) {
        var pi = 3.14159265359;

        System.out.format("[%f]\n", pi);         // [3.141593]
        System.out.format("[%12.8f]\n", pi);     // [  3.14159265]
        System.out.format("[%012f]\n", pi);      // [00003.141593]
        System.out.format("[%012.8f]\n", pi);    // [003.14159265]
        System.out.format("[%012.2f]\n", pi);    // [000000003.14]
        System.out.format("[%12.2f]\n", pi);     // [        3.14]
        System.out.format("[%.3f]\n", pi);       // [3.142]

        var str = "Food %d tons".formatted(2.0); // IllegalFormatConversionException
    }
}
