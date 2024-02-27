package com.mtopgul.lambdas.functionalInterfaces.objectMethods;

/**
 * @author muhammed-topgul
 * @since 27/02/2024 07:36
 */
@FunctionalInterface
public interface Hibernate {
    String toString();

    public abstract int hashCode();

    public boolean equals(Hibernate o);

//    public void rest();
}
