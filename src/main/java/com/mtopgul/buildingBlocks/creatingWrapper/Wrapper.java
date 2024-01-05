package com.mtopgul.buildingBlocks.creatingWrapper;

/**
 * @author muhammed-topgul
 * @since 05/01/2024 09:03
 */
public class Wrapper {
    public static void main(String[] args) {
        Double apple = Double.valueOf("200.99");
        System.out.println(apple.byteValue()); // -56
        System.out.println(apple.intValue()); // 200
        System.out.println(apple.doubleValue()); // 200.99
        System.out.println(apple.longValue()); // 200
    }
}
