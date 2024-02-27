package com.mtopgul.lambdas.functionalInterfaces.declaring;

/**
 * @author muhammed-topgul
 * @since 27/02/2024 07:28
 */
@FunctionalInterface
public interface Climb {
    void reach();

    default void fall() {}

    static int getBackup() {
        return 100;
    }

    private static boolean checkHeight() {
        return true;
    }
}
