package com.mtopgul.methods.passingDataAmongMethods;

/**
 * @author muhammed-topgul
 * @since 02/02/2024 14:44
 */
public class Chimpanzee {
    public void climb(long t) {}

    public void swing(Integer u) {}

    public void jump(int v) {}

    public void walk(short v) {}

    public void run(Long l) {}

    public static void main(String[] args) {
        Chimpanzee c = new Chimpanzee();
        c.climb(123); // Widening
        c.swing(123); // Autoboxing
        // c.jump(123L);  // DOES NOT COMPILE
        int s = 5;
        c.walk((short) 5); // Java method parametreleri için narrowing yapmaz
        c.walk((short) s);

        // c.run(5);  // DOES NOT COMPILE çünkü hem widening hem autoboxing gerekiyor
        c.run(5L);
    }
}
