package com.mtopgul;

/**
 * @author muhammed-topgul
 * @since 11/02/2024 15:36
 */
class Bird {
    int feathers = 0;

    Bird(int x) {
        this.feathers = x;
    }

    Bird fly() {
        return new Bird(1);
    }
}

class Parrot extends Bird {
    protected Parrot(int y) {
        super(y);
    }

    protected Parrot fly() {
        return new Parrot(2);
    }
}

public class Macaw extends Parrot {
    public Macaw(int z) {
        super(z);
    }

    public Macaw fly() {
        return new Macaw(3);
    }

    public static void main(String... sing) {
        Bird p = new Macaw(4);
        Parrot fly = (Parrot) p.fly();

        Parrot c = new Parrot(4);
        System.out.println(c.feathers);
        System.out.print(fly.feathers);
    }
}
