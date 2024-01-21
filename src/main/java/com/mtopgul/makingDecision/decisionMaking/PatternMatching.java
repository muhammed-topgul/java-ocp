package com.mtopgul.makingDecision.decisionMaking;

/**
 * @author muhammed-topgul
 * @since 22/01/2024 00:01
 */
public class PatternMatching {
    void compareIntegers(Number number) {
        if (number instanceof Integer) {
            Integer data = (Integer) number;
            System.out.println(data.compareTo(5));
        } else if (number instanceof Long data) {
            System.out.println(data.compareTo(5L));
        } else if (number instanceof final Short data) {
            System.out.println(data.compareTo((short) 5));
        }
    }

    void printIntegersGreaterThan5(Number number) {
        if (number instanceof Integer data && data.compareTo(5) > 0) {
            System.out.println(data);
        }
    }


}
