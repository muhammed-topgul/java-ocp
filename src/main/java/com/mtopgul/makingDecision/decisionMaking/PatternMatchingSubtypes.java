package com.mtopgul.makingDecision.decisionMaking;

import java.lang.constant.ConstantDesc;
import java.util.ArrayList;
import java.util.List;

/**
 * @author muhammed-topgul
 * @since 22/01/2024 00:20
 */
public class PatternMatchingSubtypes {
    // Subtypes
    void subtypeIntegers(Integer value) {
        if (value instanceof Integer) {
        }

        // if (value instanceof Integer data) {} // DOES NOT COMPILE
    }

    void subtypeRestriction(ArrayList<?> parent) {
        if (parent instanceof ConstantDesc desc) {
            System.out.println("list");
        } else if (parent instanceof ArrayList<?>) {
            System.out.println("array list");
        }
    }

    public static void main(String[] args) {
        PatternMatchingSubtypes ref = new PatternMatchingSubtypes();

        ref.subtypeRestriction(new ArrayList<>());
    }

}
