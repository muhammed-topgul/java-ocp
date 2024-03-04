package com.mtopgul.collectionsAndGenerics.commonApis;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/**
 * @author muhammed-topgul
 * @since 04/03/2024 07:41
 */
public class Iterating {
    public static void main(String[] args) {
        Collection<String> cats = List.of("Annie", "Ripley");
        cats.forEach(c -> System.out.println(c));
        cats.forEach(System.out::println);

        for (String cat : cats) {
            System.out.println(cat);
        }

        Iterator<String> iterator = cats.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
