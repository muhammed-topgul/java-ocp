package com.mtopgul.exceptionsAndLocalization.i18n;

import com.mtopgul.Util;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;
import java.util.stream.Stream;

/**
 * @author muhammed-topgul
 * @since 20/03/2024 09:44
 */
public class ParsingNumbers {
    public static void main(String[] args) throws ParseException {
        Util.divide("Parsing Numbers", 0);
        String number = "40.45";

        var en = NumberFormat.getInstance(Locale.US);
        System.out.println(en.parse(number)); // 40.45

        var fr = NumberFormat.getInstance(Locale.FRANCE);
        System.out.println(fr.parse(number)); // 40


        Util.divide("Parsing Currencies");
        String income = "$92,807.99";
        var cf = NumberFormat.getCurrencyInstance(Locale.US);
        double value = (double) cf.parse(income);
        System.out.println(value); // 92807.99


        Util.divide("Compact Number Format");
        Locale.setDefault(new Locale("tr"));
        Stream<NumberFormat> formatters = Stream.of(
                /* 7 Mn */        NumberFormat.getCompactNumberInstance(),
                /* 7 Mn */        NumberFormat.getCompactNumberInstance(new Locale("tr"), NumberFormat.Style.SHORT),
                /* 7 milyon */    NumberFormat.getCompactNumberInstance(new Locale("tr"), NumberFormat.Style.LONG),

                /* 7 Mio */       NumberFormat.getCompactNumberInstance(Locale.GERMAN, NumberFormat.Style.SHORT),
                /* 7 Millionen */ NumberFormat.getCompactNumberInstance(Locale.GERMAN, NumberFormat.Style.LONG),
                /* 7.123.456 */   NumberFormat.getNumberInstance());
        formatters
                .map(s -> s.format(7_123_456))
                .forEach(System.out::println);

        Util.divide();

        formatters
                .map(s -> s.format(314_900_000))
                .forEach(System.out::println);
        /*
        315 Mn
        315 Mn
        315 milyon
        315 Mio.
        315 Millionen
        314.900.000
        */

    }
}
