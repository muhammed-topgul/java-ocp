package com.mtopgul.makingDecision.decisionMaking;

/**
 * @author muhammed-topgul
 * @since 24/01/2024 07:17
 */
public class FlowScoping {
    void printIntegersOrNumbersGreaterThan5(Number number) {
        // if (number instanceof Integer data || data.compareTo(5) > 0) {} // DOES NOT COMPILE
    }

    void printIntegerTwice(Number number) {
        if (number instanceof Integer data)
            System.out.println(data.intValue());
        // System.out.println(data.intValue()); // DOES NOT COMPILE
    }

    void printOnlyIntegers(Number number) {
        if (!(number instanceof Integer data)) {
            return;
        }
        System.out.println(data.intValue());
    }

    void printOnlyIntegers1(Number number) {
        if (!(number instanceof Integer data))
            return;
        else {
            System.out.println(data.intValue());
        }

        System.out.println(data.intValue());
    }

    public void method2(Object o) {
        if (!(o instanceof String s)) {
            return;
        } else {
            System.out.println(s);
        }
        System.out.println(s);
    }
}
