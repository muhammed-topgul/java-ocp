package com.mtopgul.buildingBlocks.packagesAndImports.b;

import com.mtopgul.buildingBlocks.packagesAndImports.a.ClassA;

/**
 * @author muhammed-topgul
 * @since 04/01/2024 09:45
 */
public class ClassB {
    public static void main(String[] args) {
        ClassA a = new ClassA();
        System.out.println(a.getClass().getName());
        System.out.println("Got it!");
    }
}
