package com.mtopgul.streams.advanced.spliterator;

import java.util.List;
import java.util.Spliterator;

/**
 * @author muhammed-topgul
 * @since 11/03/2024 14:53
 */
public class Main {
    public static void main(String[] args) {
        var stream = List.of("bird-", "bunny-", "cat-", "dog-", "fish-", "lamb-", "mouse-");

        Spliterator<String> originalBogOfFood = stream.spliterator();
        Spliterator<String> emmasBag = originalBogOfFood.trySplit();
        emmasBag.forEachRemaining(System.out::print); // bird-bunny-cat-

        System.out.println();
        //originalBogOfFood.forEachRemaining(System.out::print); // dog-fish-lamb-mouse-

        Spliterator<String> jillsBag = originalBogOfFood.trySplit();
        jillsBag.tryAdvance(System.out::print); // dog-
        System.out.println();
        jillsBag.forEachRemaining(System.out::print); // fish-

        System.out.println();
        originalBogOfFood.forEachRemaining(System.out::print); // lamb-mouse-
    }
}
