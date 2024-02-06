package com.mtopgul.classDesign.initializingObjects;

/**
 * @author muhammed-topgul
 * @since 06/02/2024 11:55
 */
public class InitializationOrder extends Parent {
    static {
        System.out.println("Child.static");
    }

    {
        System.out.println("Child.instance");
    }

    public InitializationOrder() {
        System.out.println("Child.constructor");
    }

    public static void main(String[] args) {
//        new Parent();
        System.out.println("################");
        new InitializationOrder();
    }
}
