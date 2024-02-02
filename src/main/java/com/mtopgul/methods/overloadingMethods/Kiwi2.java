package com.mtopgul.methods.overloadingMethods;

/**
 * @author muhammed-topgul
 * @since 02/02/2024 15:45
 */
public class Kiwi2 {
    public void fly(long numMiles) {
        System.out.println("long");
    }

    public void fly(Long numMiles) {
        System.out.println("Long");
    }

    public static void main(String[] args) {
        Kiwi2 a = new Kiwi2();
        a.fly(1); // Java widening işlemini autoboxinge tercih eder
        a.fly(Long.valueOf(1));
        a.fly((long) 1);
        a.fly((Long) 1L);
        // a.fly((Long) 1);  // DOES NOT COMPILE
    }
}
