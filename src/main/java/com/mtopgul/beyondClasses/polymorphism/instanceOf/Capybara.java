package com.mtopgul.beyondClasses.polymorphism.instanceOf;

import com.mtopgul.beyondClasses.polymorphism.HasTail;
import com.mtopgul.beyondClasses.polymorphism.Lemur;

/**
 * @author muhammed-topgul
 * @since 19/02/2024 08:24
 */
public class Capybara extends Rodent {
    public static void main(String[] args) {
        Rodent rodent = new Rodent();
        // Capybara capybara = (Capybara) rodent; // ClassCastException

        if (rodent instanceof Capybara capybara1) {
            // Do stuff
        }

        Fish fish = new Fish();
        // Fish fish1 = (Fish) new Bird(); // DOES NOT COMPILE
        // if (fish instanceof Bird b) {} // DOES NOT COMPILE

        // HasTail hasTail = (HasTail) new Fish(); // ClassCastException
        if (fish instanceof HasTail h) {}
    }
}

class Bird {
}

class Fish {
}
