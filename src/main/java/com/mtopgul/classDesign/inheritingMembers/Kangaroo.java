package com.mtopgul.classDesign.inheritingMembers;

/**
 * @author muhammed-topgul
 * @since 07/02/2024 08:06
 */
public class Kangaroo extends Marsupial {
    @Override
    public double getAverageWeight() {
        return super.getAverageWeight() + 20;
    }
}
