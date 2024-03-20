package com.mtopgul.exceptionsAndLocalization.loadingProperties;

import com.mtopgul.Util;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * @author muhammed-topgul
 * @since 20/03/2024 11:35
 */
public class ReadingResourceBundle {
    public static void main(String[] args) {
        var us = new Locale("en", "US");
        var fr = new Locale("fr", "FR");

        printWelcomeMessage(us);
        printWelcomeMessage(fr);


        Util.divide();
        ResourceBundle resourceBundle = ResourceBundle.getBundle("Zoo", us);
        resourceBundle.keySet()
                .stream()
                .map(k -> k + ": " + resourceBundle.getString(k))
                .forEach(System.out::println);
    }

    private static void printWelcomeMessage(Locale locale) {
        var rb = ResourceBundle.getBundle("Zoo", locale);
        System.out.println(rb.getString("hello") + ", " + rb.getString("open"));
    }
}
