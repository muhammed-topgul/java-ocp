package com.mtopgul.lambdas.functionalInterfaces.methodReference.callingConstructor;

/**
 * @author muhammed-topgul
 * @since 27/02/2024 09:28
 */
public interface StringCopier {
    String copy(String value);

    static void main(String[] args) {
        StringCopier lambda = s -> new String(s);
        StringCopier methodRef = String::new;

        String java = "Java";
        String copy = methodRef.copy(java);

        System.out.println(java == copy); // false
    }
}
