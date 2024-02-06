package com.mtopgul.classDesign.initializingObjects;

/**
 * @author muhammed-topgul
 * @since 06/02/2024 12:19
 */
public class Chimpanzee extends Ape {
    public Chimpanzee() {
        super(2);
        System.out.print("Chimpanzee-");
    }

    public static void main(String[] args) {
        new Chimpanzee();
    }
}
