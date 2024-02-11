package com.mtopgul;

/**
 * @author muhammed-topgul
 * @since 11/02/2024 14:32
 */
public class Parent {
    private int age;

    public Parent() {
        new Parent(2);
    }

    public Parent(int age) {
        this.age = age;
    }

    private final void main(String[] args) {
        Parent parent = new Parent();
        System.out.println(parent.age);
    }
}


class Arthropod {


    protected void printName(long input) {
        System.out.print("Arthropod");
    }


    void printName(int input) {
        System.out.print("Spooky");
    }
}

class Spider extends Arthropod {
    protected void printName(int input) {
        System.out.print("Spider");
    }

    public static void main(String[] args) {
        Arthropod a = new Spider();
        a.printName((short) 4);
        a.printName(4);
        a.printName(5L);
    }
}
