package com.mtopgul.collectionsAndGenerics.generics.bounding;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author muhammed-topgul
 * @since 06/03/2024 21:46
 */
public class LowerBoundedWildcards {

    private static class A {

    }

    private static class B extends A {

    }

    private static class C extends B {

    }

    public static void main(String[] args) {
        List<String> strings = new ArrayList<>();
        strings.add("tweet");

        List<Object> objects = new ArrayList<>(strings);

        addSound(strings);
        addSound(objects);

        List<CharSequence> charSequences = new ArrayList<>(strings);
        addSound(charSequences);

    }

    private static void addSound(List<? super String> list) {
        list.add("quack");
    }
}
