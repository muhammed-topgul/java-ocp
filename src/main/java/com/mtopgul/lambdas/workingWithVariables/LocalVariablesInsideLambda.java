package com.mtopgul.lambdas.workingWithVariables;

import java.util.function.BinaryOperator;

/**
 * @author muhammed-topgul
 * @since 28/02/2024 13:30
 */
public class LocalVariablesInsideLambda {
    public static void main(String[] args) {
        BinaryOperator<Integer> b1 = (a, b) -> {
            int c = 0;
            return a + b;
        };
    }

    private void variables(int a) {
        int b = 1;
        /*
        Predicate<Integer> p1 = a -> { // a was already used in this scope
            int b = 0;                 // attempts to redeclare local variable b
            int c = 0;
            return b == c;}            // Must has semicolon at the end of }
        */
    }
}
