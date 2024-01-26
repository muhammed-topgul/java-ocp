package com.mtopgul;

import java.util.ArrayList;
import java.util.List;

/**
 * @author muhammed-topgul
 * @since 26/01/2024 07:28
 */
public class Deneme {
    enum Animal {BIRD, FISH, MAMMAL}

    void printLocation(Animal a) {
        long as = 1;
        long type = switch (a) {
            case BIRD -> 1L;
            case FISH -> 2;
            case MAMMAL -> 3;
            default -> 4;
        };
        System.out.print(type);
    }

    public static void main(String[] args) {
        int participants = 4, animals = 2, performers = -1;
        while((participants = participants+1) < 10) {}
        do {} while (animals++ <= 1);
        for( ; performers<2; performers+=2) {}
        System.out.println(participants);
        System.out.println(animals);
        System.out.println(performers);

    }
}
