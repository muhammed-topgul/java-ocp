package com.mtopgul.methods.passingDataAmongMethods;

/**
 * @author muhammed-topgul
 * @since 02/02/2024 14:09
 */
public class AutoboxingAndUnboxingVariables {
    public static void main(String[] args) {
        method1();
        method2();
        method7();
    }

    private static void method1() {
        int q1 = 5;
        Integer q2 = Integer.valueOf(q1); // Boxing
        int q3 = q2.intValue();           // Unboxing
    }

    private static void method2() {
        int q1 = 5;
        Integer q2 = q1; // Autoboxing
        int q3 = q2;     // Unboxing
    }

    private static void method3() {
        Short tail = 8; // Autoboxing

        Character p = Character.valueOf('p');
        char paw = p;  // Unboxing

        Boolean nose = true; // Autoboxing

        Integer i = Integer.valueOf(9);
        long ears = i; // Unboxing, then implicit casting
        // Long ears1 = i;  // DOES NOT COMPILE
        // Integer f = ears;  // DOES NOT COMPILE

        // Java autoboxing ve casting işlemini aynı anda yapmaz
        long a = 0; // Casting
        // Long b = 0; // Widening ve Autoboxing yapması gerekir. Bu yüzden yapmaz   // DOES NOT COMPILE

        // int x = 123L;  // DOES NOT COMPILE
    }


    private static void method7() {
        Integer q2 = null;
        int q3 = q2;     // NullPointerException
    }
}
