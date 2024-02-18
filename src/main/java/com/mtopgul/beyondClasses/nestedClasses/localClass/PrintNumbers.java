package com.mtopgul.beyondClasses.nestedClasses.localClass;

/**
 * @author muhammed-topgul
 * @since 18/02/2024 23:50
 */
public class PrintNumbers {
    private int length = 5;

    public void calculate() {
        final int width = 20;

        class Calculator {
            public void multiply(int age) {
                System.out.println(length * width * age);
            }
        }
        new Calculator().multiply(2);
    }

    public void processData() {
        final int length = 5;
        int width = 10;
        int height = 2;

        class Volume {
            public void multiply() {
                // System.out.println(length * width * height);// DOES NOT COMPILE
            }
        }
        width = 2;
    }

    public static void main(String[] args) {
        new PrintNumbers().calculate();
    }
}
