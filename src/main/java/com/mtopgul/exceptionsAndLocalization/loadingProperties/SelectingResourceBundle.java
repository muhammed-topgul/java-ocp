package com.mtopgul.exceptionsAndLocalization.loadingProperties;

import java.util.Locale;
import java.util.Objects;
import java.util.ResourceBundle;

/**
 * @author muhammed-topgul
 * @since 20/03/2024 11:46
 */
public class SelectingResourceBundle {
    public static void main(String[] args) {
        printUsername(null);               // Zoo_en_GB
        printUsername(new Locale("en")); // Zoo_en
        printUsername(Locale.US);                  // Zoo_en_US
        printUsername(Locale.CANADA);              // Zoo_en_CA
        printUsername(Locale.FRENCH);              // Zoo_fr
        printUsername(Locale.FRANCE);              // Zoo_fr
        printUsername(new Locale(""));   // Zoo
        printUsername(new Locale("tr")); // Zoo
    }

    private static void printUsername(Locale locale) {
        if (Objects.isNull(locale)) {
            locale = Locale.getDefault();
        }
        ResourceBundle resourceBundle = ResourceBundle.getBundle("Zoo", locale);
        System.out.println(resourceBundle.getString("username"));
    }
}
