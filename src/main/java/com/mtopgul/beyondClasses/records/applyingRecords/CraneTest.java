package com.mtopgul.beyondClasses.records.applyingRecords;

/**
 * @author muhammed-topgul
 * @since 15/02/2024 23:25
 */
public class CraneTest {
    public static void main(String[] args) {
        Crane mommy = new Crane(4, "Cammy");
        Crane father = new Crane(4, "Cammy");


        System.out.println(mommy.numberEggs());  // 4
        System.out.println(mommy.name());        // Cammy
        System.out.println(mommy);               // Crane[numberEggs=4, name=Cammy]
        System.out.println(mommy.hashCode());    // 64874007

        System.out.println(father);              // Crane[numberEggs=4, name=Cammy]
        System.out.println(father.hashCode());   // 64874007

        System.out.println(father.equals(mommy)); // true
    }
}
