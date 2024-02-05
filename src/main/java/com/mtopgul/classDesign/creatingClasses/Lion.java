package com.mtopgul.classDesign.creatingClasses;

/**
 * @author muhammed-topgul
 * @since 05/02/2024 07:35
 */
public class Lion extends Animal {
    protected void setProperties(int age, String name) {
        super.setAge(age);
        super.name = name;
    }

    public void roar() {
        System.out.println(name + ", age " + getAge() + ", says: Roar!");
    }

    public static void main(String[] args) {
        var lion = new Lion();
        lion.setProperties(3, "kion");
        lion.roar();
    }
}
