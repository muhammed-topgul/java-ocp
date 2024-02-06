package com.mtopgul.classDesign.initializingObjects;

/**
 * @author muhammed-topgul
 * @since 06/02/2024 12:06
 */
public class ZooTickets {
    private String name = "BestZoo";

    {
        System.out.print(name + "-");
    }

    private static int count = 0;

    static {
        System.out.print(count + "-");
    }

    static {
        count += 10;
        System.out.print(count + "-");
    }

    public ZooTickets() {
        System.out.print("z-");
    }

    public static void main(String[] args) {
        new ZooTickets();
    }
}
