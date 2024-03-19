package com.mtopgul.exceptionsAndLocalization.suppressedExceptions;

/**
 * @author muhammed-topgul
 * @since 19/03/2024 14:52
 */
public class TurkeyCage implements AutoCloseable {
    @Override
    public void close() throws IllegalStateException {
        throw new IllegalStateException("Close exception");
    }

    public static void main(String[] args) {
        try(TurkeyCage cage = new TurkeyCage()) {
            throw new IllegalStateException("Try exception");
        } catch (IllegalStateException e) {
            System.out.println("Caught: " + e.getMessage());
            for (Throwable throwable : e.getSuppressed()) {
                System.out.println("Suppressed: " + throwable.getMessage());
            }
        }
    }
}
