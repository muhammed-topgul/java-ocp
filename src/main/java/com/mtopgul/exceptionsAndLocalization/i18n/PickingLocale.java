package com.mtopgul.exceptionsAndLocalization.i18n;

import com.mtopgul.Util;

import java.util.Locale;

/**
 * @author muhammed-topgul
 * @since 20/03/2024 09:02
 */
public class PickingLocale {
    public static void main(String[] args) {
        Util.divide("ex01");
        Locale locale = Locale.getDefault();
        System.out.println(locale.getLanguage()); // en
        System.out.println(locale.getCountry());  // GB
        System.out.println(locale);               // en_GB

        Util.divide("ex02");
        System.out.println(Locale.GERMAN);  // de
        System.out.println(Locale.GERMANY); // de_DE

        Util.divide("ex03");
        System.out.println(new Locale("tr"));                 // tr
        System.out.println(new Locale("tr", "TR")); // tr_TR

        Util.divide("ex04");
        Locale locale1 = new Locale.Builder()
                .setLanguage("en")
                .setRegion("US")
                .build();
        System.out.println(locale1); // en_US

        Locale locale2 = new Locale.Builder()
                .setLanguage("tr")
                .setRegion("TR")
                .build();
        System.out.println(locale2); // tr_TR


        Util.divide("ex05");
        locale = new Locale("tur", "TR");
        Locale.setDefault(locale);
        System.out.println(Locale.getDefault()); // tur_TR
    }
}
