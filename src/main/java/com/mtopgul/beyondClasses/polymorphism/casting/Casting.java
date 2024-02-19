package com.mtopgul.beyondClasses.polymorphism.casting;

import com.mtopgul.beyondClasses.polymorphism.HasTail;
import com.mtopgul.beyondClasses.polymorphism.Lemur;
import com.mtopgul.beyondClasses.polymorphism.Primate;
import com.mtopgul.beyondClasses.polymorphism.Primate1;
import com.mtopgul.beyondClasses.polymorphism.Primate2;

/**
 * @author muhammed-topgul
 * @since 19/02/2024 07:48
 */
public class Casting {
    public static void main(String[] args) {
        Lemur lemur = new Lemur();

        Primate primate = lemur;        // Implicit cast to supertype

        Lemur lemur1 = (Lemur) primate; // Explicit cast to subtype

        // Lemur lemur2 = primate;      // DOES NOT COMPILE (missing cast)

        {
            primate = new Primate();
            // Lemur lemur2 = (Lemur) primate;       // ClassCastException
            // HasTail hasTail = (HasTail) primate;  // ClassCastException

            // HasTail hasTail = (HasTail) new Primate1(); // DOES NOT COMPILE
            // Primate2 hasTail = (Primate2) new Primate();  // DOES NOT COMPILE
        }
    }
}
