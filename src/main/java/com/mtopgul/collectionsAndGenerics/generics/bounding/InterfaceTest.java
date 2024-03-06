package com.mtopgul.collectionsAndGenerics.generics.bounding;

import java.util.ArrayList;
import java.util.List;

/**
 * @author muhammed-topgul
 * @since 06/03/2024 16:13
 */
public class InterfaceTest {
    public static void main(String[] args) {
        List<Flyer> flyers = new ArrayList<>();
        flyers.add(new Goose());
        flyers.add(new HangGlider());
        anyFlyer(flyers);

        List<Goose> geese = new ArrayList<>();
        geese.add(new Goose());

        groupOfFlyer(geese);
    }

    private static void anyFlyer(List<Flyer> flyers) {
        flyers.forEach(Flyer::fly);
    }

    private static void groupOfFlyer(List<? extends Flyer> flyers) {
        flyers.forEach(Flyer::fly);
    }
}

interface Flyer {
    void fly();
}

class HangGlider implements Flyer {
    @Override
    public void fly() {
        System.out.println("HangGlider");
    }
}

class Goose implements Flyer {
    @Override
    public void fly() {
        System.out.println("Goose");
    }
}
