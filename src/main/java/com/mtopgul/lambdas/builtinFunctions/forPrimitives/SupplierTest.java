package com.mtopgul.lambdas.builtinFunctions.forPrimitives;

import java.util.function.DoubleSupplier;
import java.util.function.IntSupplier;
import java.util.function.LongSupplier;
import java.util.function.Supplier;

/**
 * @author muhammed-topgul
 * @since 28/02/2024 09:22
 */
public class SupplierTest {
    public static void main(String[] args) {
        // Double
        Supplier<Double> supplierDouble = () -> Math.random();
        DoubleSupplier doubleSupplier = () -> Math.random();
        System.out.println(supplierDouble.get());
        System.out.println(doubleSupplier.getAsDouble());

        // Int
        Supplier<Integer> supplierInteger = () -> (int) (Math.random() * 10);
        IntSupplier intSupplier = () -> (int) (Math.random() * 10);
        System.out.println(supplierInteger.get());
        System.out.println(intSupplier.getAsInt());

        // Long
        Supplier<Long> supplierLong = () -> 1L;
        LongSupplier longSupplier = () -> 1;
        System.out.println(supplierLong.get());
        System.out.println(longSupplier.getAsLong());
    }
}
