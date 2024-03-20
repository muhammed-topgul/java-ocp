package com.mtopgul.exceptionsAndLocalization.formattingValues;

import com.mtopgul.Util;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;

/**
 * @author muhammed-topgul
 * @since 20/03/2024 07:31
 */
public class FormattingDatesAndTimes {
    public static void main(String[] args) {
        Util.divide("", 0);
        LocalDate date = LocalDate.of(2022, Month.OCTOBER, 20);
        System.out.println(date.getDayOfWeek());  // THURSDAY
        System.out.println(date.getMonth());      // OCTOBER
        System.out.println(date.getYear());       // 2022
        System.out.println(date.getDayOfYear());  // 293


        Util.divide("DateTimeFormatter");
        LocalTime time = LocalTime.of(11, 12, 34);
        LocalDateTime dateTime = LocalDateTime.of(date, time);

        System.out.println(dateTime); // 2022-10-20T11:12:34
        System.out.println(dateTime.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME)); // 2022-10-20T11:12:34
        System.out.println(date.format(DateTimeFormatter.ISO_LOCAL_DATE)); // 2022-10-20
        System.out.println(time.format(DateTimeFormatter.ISO_LOCAL_TIME)); // 11:12:34

        // Exceptions
        date.format(DateTimeFormatter.ISO_LOCAL_TIME); // RuntimeException
        time.format(DateTimeFormatter.ISO_LOCAL_DATE); // RuntimeException
    }
}
