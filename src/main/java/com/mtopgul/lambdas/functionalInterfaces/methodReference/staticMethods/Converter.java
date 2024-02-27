package com.mtopgul.lambdas.functionalInterfaces.methodReference.staticMethods;

/**
 * @author muhammed-topgul
 * @since 27/02/2024 07:58
 */
@FunctionalInterface
public interface Converter {
    long round(double num);

    static void main(String[] args) {
        Converter lambda1 = x -> (long) x;
        Converter lambda2 = x -> Math.round(x);
        Converter methodRef = Math::round;

        System.out.println(lambda1.round(100.1));
        System.out.println(lambda2.round(100.1));
        System.out.println(methodRef.round(100.1));
    }
}
