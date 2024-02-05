package com.mtopgul.classDesign.creatingClasses;

/**
 * @author muhammed-topgul
 * @since 05/02/2024 10:13
 */
public class Crocodile extends Reptile {
    protected int speed = 20;

    public int getSpeed() {
        return speed;
    }

    public int getSpeed1() {
        return super.speed;
    }

    public int getSpeed2() {
        return Crocodile.super.speed;
    }

    public static void main(String[] args) {
        Crocodile crocodile = new Crocodile();
        System.out.println(crocodile.speed);
        System.out.println(crocodile.getSpeed());
        System.out.println(crocodile.getSpeed1());
        System.out.println(crocodile.getSpeed2());

    }
}
