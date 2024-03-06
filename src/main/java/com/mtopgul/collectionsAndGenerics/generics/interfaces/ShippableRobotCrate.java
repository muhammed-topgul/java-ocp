package com.mtopgul.collectionsAndGenerics.generics.interfaces;

/**
 * @author muhammed-topgul
 * @since 06/03/2024 15:20
 */
public class ShippableRobotCrate implements Shippable<Robot> {
    @Override
    public void ship(Robot robot) {
        System.out.println("Robot shipping...");
    }
}
