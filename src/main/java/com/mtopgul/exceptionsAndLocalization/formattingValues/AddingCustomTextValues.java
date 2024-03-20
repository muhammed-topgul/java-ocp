package com.mtopgul.exceptionsAndLocalization.formattingValues;

import com.mtopgul.Util;

import java.time.LocalDateTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;

/**
 * @author muhammed-topgul
 * @since 20/03/2024 08:14
 */
public class AddingCustomTextValues {
    public static void main(String[] args) {
        Util.divide("Bad Formatting", 0);
        var dateTime = LocalDateTime.of(2022, Month.OCTOBER, 20, 6, 15, 30);
        var f1 = DateTimeFormatter.ofPattern("MMMM dd, yyyy ");
        var f2 = DateTimeFormatter.ofPattern(" hh:mm");
        System.out.println(dateTime.format(f1) + "at" + dateTime.format(f2)); // October 20, 2022 at 06:15


        Util.divide("Best Formatting");
        var f3 = DateTimeFormatter.ofPattern("MMMM dd, yyyy 'at' hh:mm");
        System.out.println(dateTime.format(f3)); // October 20, 2022 at 06:15

        var f4 = DateTimeFormatter.ofPattern("MMMM dd', Party''s at' hh:mm");
        System.out.println(dateTime.format(f4)); // October 20, Party's at 06:15

        var f5 = DateTimeFormatter.ofPattern("'System format, hh:mm: ' hh:mm");
        System.out.println(dateTime.format(f5)); // System format, hh:mm:  06:15

        var f6 = DateTimeFormatter.ofPattern("'NEW! 'yyyy', yay!'");
        System.out.println(dateTime.format(f6)); // NEW! 2022, yay!
    }
}
