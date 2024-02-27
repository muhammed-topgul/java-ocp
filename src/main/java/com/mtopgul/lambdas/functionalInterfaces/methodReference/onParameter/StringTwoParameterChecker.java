package com.mtopgul.lambdas.functionalInterfaces.methodReference.onParameter;

/**
 * @author muhammed-topgul
 * @since 27/02/2024 09:24
 */
public interface StringTwoParameterChecker {
    boolean check(String text, String prefix);

    static void main(String[] args) {
        StringTwoParameterChecker lambda = (t, p) -> t.startsWith(p);
        StringTwoParameterChecker methodRef = String::startsWith;

        System.out.println(lambda.check("Java", "J"));
        System.out.println(methodRef.check("Java", "J"));
    }
}
