package com.mtopgul.methods.varargs;

/**
 * @author muhammed-topgul
 * @since 01/02/2024 15:59
 */
public class VisitAttractions {
    public static void walk1(int... steps) {
        int[] newSteps = steps;
        System.out.println(steps.getClass());
        System.out.println(newSteps.getClass());
        System.out.println(steps.length);
        System.out.println(newSteps.length);
    }

    public void walk2(int start, int... steps) {
    }

    // public void walk3(int... steps, int start) {} // DOES NOT COMPILE

    // public void walk4(int...start, int...steps) {} // DOES NOT COMPILE

    public static void main(String[] args) {
        VisitAttractions.walk1(1, 2, 3);
        VisitAttractions.walk1(new int[]{1, 2});
        VisitAttractions.walk1();
        VisitAttractions.walk1(null);
    }
}
