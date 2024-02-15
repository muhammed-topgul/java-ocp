package com.mtopgul.beyondClasses.implementingInterfaces;

/**
 * @author muhammed-topgul
 * @since 15/02/2024 07:33
 */
public interface IsColdBlooded {
    /**
     Default Interface Method Definition Rules
     1. A default method may be declared only within an interface.
     2. A default method must be marked with the default keyword and include a method body.
     3. A default method is implicitly public.
     4. A default method cannot be marked private, abstract, final, or static.
     5. A default method may be overridden by a class that implements the interface.
     6. If a class inherits two or more default methods with the same method signature, then the
        class must override the method
     */
    boolean hasScales();

    // A default method cannot be marked abstract, final, or static
    public default double getTemperature1() {
        return 10.1;
    }

    default public double getTemperature2() {
        return 10.2;
    }

    default double getTemperature3() {
        return 10.3;
    }
}
