package com.mtopgul.exceptionsAndLocalization.formattingValues;

import com.mtopgul.Util;

import java.time.LocalDateTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;

/**
 * @author muhammed-topgul
 * @since 20/03/2024 07:41
 */
public class CustomizingDateTimeFormat {
    private static final LocalDateTime dateTime = LocalDateTime.of(2022, Month.OCTOBER, 20, 6, 15, 30);

    public static void main(String[] args) {
        ex01();
        ex02();
        ex03();
        ex04();
    }

    private static void ex01() {
        Util.divide("Ex01", 0);
        LocalDateTime dateTime = LocalDateTime.of(2022, Month.DECEMBER, 20, 11, 12);
        var formatter = DateTimeFormatter.ofPattern("MMMM dd, yyyy 'at' hh:mm");  // December 20, 2022 at 11:12
        System.out.println(dateTime.format(formatter));
    }

    private static void ex02() {
        Util.divide("Ex02");
        var formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy hh:mm:ss");
        System.out.println(dateTime.format(formatter)); // 10/20/2022 6:15:30
    }

    private static void ex03() {
        Util.divide("Ex03");
        var formatter = DateTimeFormatter.ofPattern("MM__yyyy_-_dd");
        System.out.println(dateTime.format(formatter)); // 10__2022_-_20
    }

    private static void ex04() {
        Util.divide("Ex04");
        var formatter = DateTimeFormatter.ofPattern("h:mm z");
        System.out.println(dateTime.format(formatter)); // DateTimeException
    }
}
