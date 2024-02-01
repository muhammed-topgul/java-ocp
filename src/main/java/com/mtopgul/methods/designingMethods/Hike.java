package com.mtopgul.methods.designingMethods;

/**
 * @author muhammed-topgul
 * @since 01/02/2024 14:01
 */
public class Hike {
    public void hike1() {}

    public void hike2() {return;}

    public String hike3() {return "";}

    // public String hike4() {}  // DOES NOT COMPILE

    // public hike5() {} // DOES NOT COMPILE

    // public String int hike6() {} // DOES NOT COMPILE

    String hike7(int a) {
        if (1 < 3) return "orange";
        return "blue"; // DOES NOT COMPILE without this line
    }
}
