package com.mtopgul.exceptionsAndLocalization.i18n;

import java.text.NumberFormat;
import java.util.Locale;

/**
 * @author muhammed-topgul
 * @since 20/03/2024 10:45
 */
public class LocaleCategory {
    public static void main(String[] args) {
        var spain = new Locale("es", "ES");
        var money = 1.23;

        printCurrency(spain, money); // £1.23, Spanish

        Locale.setDefault(new Locale("tr", "TR"));
        printCurrency(spain, money); // ₺1,23, İspanyolca

        Locale.setDefault(Locale.Category.DISPLAY, spain);
        printCurrency(spain, money); // ₺1.23, español

        Locale.setDefault(Locale.Category.FORMAT, spain);
        printCurrency(spain, money); // 1,23 €, español
    }

    private static void printCurrency(Locale locale, double money) {
        String moneyFormat = NumberFormat.getCurrencyInstance().format(money);
        System.out.println(moneyFormat + ", " + locale.getDisplayLanguage());
    }
}
