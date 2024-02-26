package com.mtopgul.lambdas.firstExample;

/**
 * @author muhammed-topgul
 * @since 26/02/2024 23:32
 */
public class CheckIfHopper implements CheckTrait {
    @Override
    public boolean test(Animal animal) {
        return animal.canHop();
    }
}
