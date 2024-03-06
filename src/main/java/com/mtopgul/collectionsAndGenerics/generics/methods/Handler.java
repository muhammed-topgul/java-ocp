package com.mtopgul.collectionsAndGenerics.generics.methods;

import com.mtopgul.collectionsAndGenerics.generics.creating.Crate;

/**
 * @author muhammed-topgul
 * @since 06/03/2024 15:29
 */
public class Handler {
    public static <T> void prepare(T t) {
        System.out.println("Preparing " + t);
    }

    public static <T> Crate<T> ship(T t) {
        System.out.println("Shipping " + t);
        Crate<T> crate = new Crate<>();
        crate.packCrate(t);
        return crate;
    }

    public static void main(String[] args) {
        Handler.prepare("Java");
        Handler.prepare(58);

        Crate<String> ship = Handler.ship("Java");
        System.out.println(ship.lookInCrate());

        Handler.<Double>prepare(25.5);
    }
}
