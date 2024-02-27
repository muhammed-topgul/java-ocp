package com.mtopgul.lambdas.functionalInterfaces.methodReference.callingConstructor;

/**
 * @author muhammed-topgul
 * @since 27/02/2024 09:27
 */
public interface EmptyStringCreator {
    String create();

    static void main(String[] args) {
        EmptyStringCreator lambda = () -> new String();
        EmptyStringCreator methodRef = String::new;
    }
}
