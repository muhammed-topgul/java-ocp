package com.mtopgul.classDesign.creatingClasses.p2;

import com.mtopgul.classDesign.creatingClasses.p1.SuperClass;

/**
 * @author muhammed-topgul
 * @since 05/02/2024 07:39
 */
public class SubClass extends SuperClass {
    void method() {
        // System.out.println(privateVar); // DOES NOT COMPILE
        // System.out.println(packageVar); // DOES NOT COMPILE
        System.out.println(protectedVar);
        System.out.println(publicVar);
    }

    public static void main(String[] args) {
        SubClass subClass = new SubClass();
        subClass.method();
    }
}
