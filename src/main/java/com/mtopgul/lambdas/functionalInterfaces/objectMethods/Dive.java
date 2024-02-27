package com.mtopgul.lambdas.functionalInterfaces.objectMethods;

/**
 * @author muhammed-topgul
 * @since 27/02/2024 07:35
 */
@FunctionalInterface
public interface Dive {
    String toString();

    public boolean equals(Object o);

    public abstract int hashCode();

    public void dive();
}
