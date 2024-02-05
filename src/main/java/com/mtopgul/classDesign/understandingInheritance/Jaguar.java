package com.mtopgul.classDesign.understandingInheritance;

/**
 * @author muhammed-topgul
 * @since 05/02/2024 07:24
 */
public class Jaguar extends BigCat {
    public Jaguar() {
        size = 10.2;
    }

    public void printDetails() {
        System.out.println(size);
    }

    public static void main(String[] args) {
        Jaguar jaguar = new Jaguar();
        jaguar.printDetails();
    }
}
