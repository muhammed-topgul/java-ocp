package com.mtopgul.lambdas.workingWithVariables;

import java.util.function.Consumer;

/**
 * @author muhammed-topgul
 * @since 28/02/2024 13:55
 */
public class ReferencingVariablesFromLambda {
    private String color;
    private static int num = 5;

    public void caw(String name) {
        num = 4;
        color = "red";
        name = "caty";
        String volume = "loudly";
        Consumer<String> consumer = s -> {
            s = "java";
            System.out.println(s);
            System.out.println(num);
            System.out.println(color);
            // System.out.println(name);    // DOES NOT COMPILE
            // System.out.println(volume);  // DOES NOT COMPILE
            // Local variables and method parameters must be final or effectively final to use inside lambda body
        };
        consumer.accept("");
        volume = "softly";
    }

    public static void main(String[] args) {
        var object = new ReferencingVariablesFromLambda();
        object.caw("johnny");
    }
}
