package com.mtopgul.methods.overloadingMethods;

/**
 * @author muhammed-topgul
 * @since 02/02/2024 15:42
 */
public class Kiwi1 {
    public void fly(int numMiles) {
        System.out.println("int");
    }

    public void fly(Integer numMiles) {
        System.out.println("Integer");
    }

    public static void main(String[] args) {
        Kiwi1 a = new Kiwi1();
        a.fly(1);
        a.fly(Integer.valueOf(1));
    }
}
