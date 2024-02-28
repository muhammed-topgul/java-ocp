package com.mtopgul.lambdas.builtinFunctions;

import java.util.function.BinaryOperator;
import java.util.function.UnaryOperator;

/**
 * @author muhammed-topgul
 * @since 28/02/2024 07:32
 */
public class UnaryAndBinaryOperatorTest {
    public static void main(String[] args) {
        {
            UnaryOperator<String> unaryOperator1 = x -> x.toUpperCase();
            UnaryOperator<String> unaryOperator2 = String::toUpperCase;

            System.out.println(unaryOperator1.apply("Java"));
            System.out.println(unaryOperator2.apply("Java"));
        }

        {
            BinaryOperator<String> binaryOperator1 = (a, b) -> a.concat(b);
            BinaryOperator<String> binaryOperator2 = String::concat;
            System.out.println(binaryOperator1.apply("Java", "SE"));
            System.out.println(binaryOperator2.apply("Java", "SE"));
        }
    }
}
