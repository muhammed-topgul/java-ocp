package com.mtopgul.lambdas.builtinFunctions;

import java.util.function.BiFunction;
import java.util.function.Function;

/**
 * @author muhammed-topgul
 * @since 28/02/2024 07:25
 */
public class FunctionTest {
    public static void main(String[] args) {
        {
            Function<String, Integer> anonymous = new Function<String, Integer>() {
                @Override
                public Integer apply(String x) {
                    return x.length();
                }
            };
            Function<String, Integer> lambda = x -> x.length();
            Function<String, Integer> methodRef = String::length;

            System.out.println(anonymous.apply("Java")); // 4
            System.out.println(lambda.apply("OCP"));     // 3
            System.out.println(methodRef.apply(".Net")); // 4
        }

        {
            BiFunction<String, String, String> biFunction1 = (a, b) -> a.concat(b);
            BiFunction<String, String, String> biFunction2 = String::concat;
        }
    }
}
