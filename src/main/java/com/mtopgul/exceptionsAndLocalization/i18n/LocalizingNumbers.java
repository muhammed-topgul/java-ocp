package com.mtopgul.exceptionsAndLocalization.i18n;

import com.mtopgul.Util;

import java.text.NumberFormat;
import java.util.Locale;

/**
 * @author muhammed-topgul
 * @since 20/03/2024 09:22
 */
public class LocalizingNumbers {
    public static void main(String[] args) {
        formattingNumbers();
        formattingCurrencies();
        formattingPercentages();
    }

    private static void formattingNumbers() {
        Util.divide("Formatting Numbers", 0);

        int attendeesPerYear = 3_200_000;
        int attendeesPerMonth = attendeesPerYear / 12;

        var us = NumberFormat.getInstance(Locale.US);
        System.out.println(us.format(attendeesPerMonth)); // 266,666

        var gr = NumberFormat.getInstance(Locale.GERMAN);
        System.out.println(gr.format(attendeesPerMonth)); // 266.666

        var tr = NumberFormat.getInstance(new Locale("tr"));
        System.out.println(tr.format(attendeesPerMonth)); // 266.666

        tr = NumberFormat.getInstance(new Locale("tr", "TR"));
        System.out.println(tr.format(attendeesPerMonth)); // 266.666
    }

    private static void formattingCurrencies() {
        Util.divide("Formatting Currencies");
        double price = 48;

        var myLocale = NumberFormat.getCurrencyInstance();
        System.out.println(myLocale.format(price)); // £48.00

        var tr = NumberFormat.getCurrencyInstance(new Locale("en", "US"));
        System.out.println(tr.format(price)); // $48.00
    }

    private static void formattingPercentages() {
        Util.divide("Formatting Percentages");
        double successRate = 0.802;

        var us = NumberFormat.getPercentInstance(Locale.US);
        System.out.println(us.format(successRate)); // 80%

        var gr = NumberFormat.getPercentInstance(Locale.GERMAN);
        System.out.println(gr.format(successRate)); // 80 %

        var tr = NumberFormat.getPercentInstance(new Locale("tr"));
        System.out.println(tr.format(successRate)); // %80
    }
}
