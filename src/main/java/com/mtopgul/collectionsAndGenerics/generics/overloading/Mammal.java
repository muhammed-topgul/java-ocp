package com.mtopgul.collectionsAndGenerics.generics.overloading;

import java.util.List;

/**
 * @author muhammed-topgul
 * @since 06/03/2024 15:13
 */
public class Mammal {
    public List<CharSequence> play() {
        return List.of("Java");
    }

    public CharSequence sleep() {
        return "Java";
    }
}

class Monkey extends Mammal {
    @Override
    public List<CharSequence> play() {
        return super.play();
    }
}

class Goat extends Mammal {
    /* public List<String> play() {} */ // DOES NOT COMPILE

    @Override
    public String sleep() {
        return (String) super.sleep();
    }
}
