package com.mtopgul.classDesign.initializingObjects;

/**
 * @author muhammed-topgul
 * @since 06/02/2024 11:56
 */
public class Parent {
    static {
        System.out.println("Parent.static");
    }

    {
        System.out.println("Parent.instance");
    }

    public Parent() {
        System.out.println("Parent.constructor");
    }
}
