package com.mtopgul.beyondClasses.nestedClasses.nestedClass;

/**
 * @author muhammed-topgul
 * @since 18/02/2024 23:46
 */
public class Park {
    static class Ride {
        private int price = 6;

        public int getPrice() {
            return price;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Ride().price);
    }
}
