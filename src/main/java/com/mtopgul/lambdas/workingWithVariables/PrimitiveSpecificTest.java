package com.mtopgul.lambdas.workingWithVariables;

import java.util.function.ToDoubleBiFunction;
import java.util.function.ToDoubleFunction;
import java.util.function.ToIntBiFunction;
import java.util.function.ToIntFunction;
import java.util.function.ToLongFunction;

/**
 * @author muhammed-topgul
 * @since 28/02/2024 13:07
 */
public class PrimitiveSpecificTest {
    public static void main(String[] args) {
        // ToDoubleFunction<T>
        ToDoubleFunction<String> toDoubleFunction = Double::valueOf;
        System.out.println(toDoubleFunction.applyAsDouble("25"));

        // ToIntFunction<T>
        ToIntFunction<String> toIntFunction = Integer::valueOf;
        System.out.println(toIntFunction.applyAsInt("1"));

        // ToLongFunction<T>
        ToLongFunction<String> toLongFunction = Long::valueOf;
        System.out.println(toLongFunction.applyAsLong("45"));

        // ToDoubleBiFunction<T, U>
        ToDoubleBiFunction<String, Integer> toDoubleBiFunction = (@Deprecated var a, final var b) -> a.length() + b;
        System.out.println(toDoubleBiFunction.applyAsDouble("Java", 17));

        // ToIntBiFunction
        ToIntBiFunction<String, String> toIntBiFunction = (a, b) -> a.length() * b.length();
        System.out.println(toIntBiFunction.applyAsInt("java", "se"));
    }
}
