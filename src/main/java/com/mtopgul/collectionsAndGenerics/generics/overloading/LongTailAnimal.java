package com.mtopgul.collectionsAndGenerics.generics.overloading;

import java.util.ArrayList;
import java.util.List;

/**
 * @author muhammed-topgul
 * @since 06/03/2024 12:58
 */
public class LongTailAnimal {
    protected void chew(List<Integer> input) {
    }

    // Cannot overload a generic method.
    /* protected void chew(List<Double> input) {} */ // DOES NOT COMPILE
}


class Anteater extends LongTailAnimal {
    /* protected void chew(List<Double> input) {} */ // DOES NOT COMPILE

    protected void chew(List<Integer> input) {}

    protected void chew(ArrayList<Double> input) {}
}