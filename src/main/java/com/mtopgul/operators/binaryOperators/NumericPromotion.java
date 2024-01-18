package com.mtopgul.operators.binaryOperators;

/**
 * @author muhammed-topgul
 * @since 18/01/2024 23:30
 */
public class NumericPromotion {
    /*
     * Numeric Promotion Rules
     * 1. If two values have different data types, Java will automatically promote one of the values to the larger of the two data types.
     * 2. If one of the values is integral and the other is floating-point, Java will automatically
          promote the integral value to the floating-point value’s data type.
     * 3. Smaller data types, namely, byte, short, and char, are first promoted to int any time
          they’re used with a Java binary arithmetic operator with a variable (as opposed to a value), even if neither of the operands is int.
     * 4. After all promotion has occurred and the operands have the same data type,
          the resulting value will have the same data type as its promoted operands.
     */
    public static void main(String[] args) {
        {
            // # Rule-1
            int x = 1;
            long y = 33;
            var z = x * y;
            typeName(z); // long
        }
        {
            // # Rule-1
            double x = 39.21;
            float y = 2.1F;
            var z = x + y;
            typeName(z); // double
        }
        {
            // # Rule-2
            int x = 21;
            float y = 2.1F;
            var z = x + y;
            typeName(z); // float
        }
        {
            // # Rule-3
            short x = 10;
            short y = 3;
            var z = x * y;
            typeName(z); // int
        }
        {
            short w = 14;
            float x = 13;
            double y = 30;
            var z = w * x / y;
            typeName(z); // double
        }
    }

    private static <T> void typeName(T o) {
        System.out.println(o.getClass().getSimpleName().toLowerCase());
    }
}
