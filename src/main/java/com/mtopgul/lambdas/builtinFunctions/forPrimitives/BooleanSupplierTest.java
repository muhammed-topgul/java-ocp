package com.mtopgul.lambdas.builtinFunctions.forPrimitives;

import java.util.function.BooleanSupplier;

/**
 * @author muhammed-topgul
 * @since 28/02/2024 09:16
 */
public class BooleanSupplierTest {
    public static void main(String[] args) {
        BooleanSupplier b1 = () -> true;
        BooleanSupplier b2 = () -> Math.random() > .5;
        System.out.println(b1.getAsBoolean());
        System.out.println(b2.getAsBoolean());
    }
}
