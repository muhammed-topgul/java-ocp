package com.mtopgul.lambdas.builtinFunctions;

import java.util.HashMap;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

/**
 * @author muhammed-topgul
 * @since 27/02/2024 19:10
 */
public class ConsumerTest {
    public static void main(String[] args) {
        {
            Consumer<String> consumer1 = x -> System.out.println(x);
            Consumer<String> consumer2 = System.out::println;

            consumer1.accept("Java");
            consumer2.accept("Spring");
        }

        {
            var map = new HashMap<String, Integer>();
            BiConsumer<String, Integer> biConsumer1 = (a, b) -> map.put(a, b);
            BiConsumer<String, Integer> biConsumer2 = map::put;

            biConsumer1.accept("0", 0);
            biConsumer2.accept("1", 0);
            System.out.println(map);
        }

        {
            var map = new HashMap<String, String>();
            BiConsumer<String, String> biConsumer1 = (a, b) -> map.put(a, b);
            BiConsumer<String, String> biConsumer2 = map::put;

            biConsumer1.accept("0", "Java");
            biConsumer2.accept("1", "OCP");
            System.out.println(map);
        }
    }
}
