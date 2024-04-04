package com.mtopgul.io.serializingData;

import java.io.Serializable;

/**
 * @author muhammed-topgul
 * @since 04/04/2024 16:30
 */
public class Cat implements Serializable {
    private String name;
    private int age;
    private String color = "white";

    public Cat() {
        System.out.println("No args constructor...");
    }

    public Cat(String name, int age, String color) {
        System.out.println("All args constructor...");
        this.name = name;
        this.age = age;
        this.color = color;
    }

    public String getName() {
        System.out.println("getName");
        return name;
    }

    public void setName(String name) {
        System.out.println("setName");
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", color='" + color + '\'' +
                '}';
    }
}
