package com.mtopgul.lambdas.functionalInterfaces.declaring;

/**
 * @author muhammed-topgul
 * @since 27/02/2024 07:27
 */
// @FunctionalInterface
public interface Sleep {
    private void snore() {}

    default int geZzz() {
        return 1;
    }
}
