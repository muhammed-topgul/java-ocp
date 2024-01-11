package com.mtopgul.buildingBlocks.declaringVariables;

/**
 * @author muhammed-topgul
 * @since 11/01/2024 07:46
 */
public class DeclaringMultipleVariables {
    void sandFence() {
        {
            String s1, s2;
            String s3 = "yes", s4 = "no";
            int i1, i2, i3 = 0;
            // int num, String name;  // DOES NOT COMPILE
        }


        {
            boolean b1, b2;
            String s1 = "1", s2;
            // double d1, double d2; // DOES NOT COMPILE
            int i1;
            int i2;
            // int i3; i4;           // DOES NOT COMPILE
        }
    }
}
