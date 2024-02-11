package com.mtopgul.classDesign.creatingClasses;

/**
 * @author muhammed-topgul
 * @since 10/02/2024 17:07
 */
public class Beetle extends Insect {
    protected int numberOfLegs = 6;
    short age = 3;

    public void printData() {
        System.out.println(this.label);           // buggy
        System.out.println(super.label);          // buggy
        System.out.println(this.age);             // 3
        // System.out.println(super.age);         // DOES NOT COMPILE
        System.out.println(numberOfLegs);         // 6
        System.out.println(super.numberOfLegs);   // 4
    }

    public static void main(String[] args) {
        new Beetle().printData();
    }
}
