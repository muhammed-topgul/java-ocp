package com.mtopgul.lambdas.functionalInterfaces.methodReference.instanceMethod;

/**
 * @author muhammed-topgul
 * @since 27/02/2024 08:15
 */
public interface StringChecker {
    boolean check();

    static void main(String[] args) {
        check("");
    }

    private static void check(String str) {
        StringChecker methodRef = str::isEmpty;
        StringChecker lambda = () -> str.isEmpty();

        System.out.println(methodRef.check()); // true
        System.out.println(lambda.check());    // true
    }
}
