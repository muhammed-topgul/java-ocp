package com.mtopgul.classDesign.creatingClasses;

/**
 * @author muhammed-topgul
 * @since 05/02/2024 07:34
 */
public class Animal {
    private int age;
    protected String name;
    protected int speed = 1;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
