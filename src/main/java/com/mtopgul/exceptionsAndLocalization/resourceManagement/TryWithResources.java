package com.mtopgul.exceptionsAndLocalization.resourceManagement;

/**
 * @author muhammed-topgul
 * @since 19/03/2024 14:38
 */
public class TryWithResources {
    public static void main(String[] args) {
        try (var f1 = new MyFileClass(1); var f2 = new MyFileClass(2)) {
            System.out.println("some operations...");
        }

        System.out.println("--------------\n");

        try (MyFileClass f1 = new MyFileClass(3)) {
            System.out.println("Second try");
            throw new RuntimeException();
        } catch (Exception e) {
            System.out.println("Catch block");
        } finally {
            System.out.println("Finally Block");
        }
    }
}
