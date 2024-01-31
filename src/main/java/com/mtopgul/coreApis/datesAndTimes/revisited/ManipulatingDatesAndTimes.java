package com.mtopgul.coreApis.datesAndTimes.revisited;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.temporal.ChronoUnit;

/**
 * @author muhammed-topgul
 * @since 31/01/2024 10:52
 */
public class ManipulatingDatesAndTimes {
    public static void main(String[] args) {
        manipulateLocalTime();
        manipulateLocalDate();
        manipulateLocalDateTime();
    }

    private static void manipulateLocalTime() {
        System.out.println("\n##### Local Time #####");
        LocalTime time = LocalTime.of(10, 39, 45, 2000000);
        System.out.println(time);                                // 10:39:45.002
        System.out.println(time.plusHours(5));        // 15:39:45.002
        System.out.println(time.plusMinutes(25));   // 11:04:45.002
        System.out.println(time.plusSeconds(5));    // 10:39:50.002
        System.out.println(time.plusNanos(100));      // 10:39:45.002000100

        // System.out.println(time.plus(1, ChronoUnit.DAYS)); // Exception
        System.out.println(time.plus(1, ChronoUnit.HOURS)); // 11:39:45.002
    }

    private static void manipulateLocalDate() {
        System.out.println("\n##### Local Date #####");
        LocalDate date = LocalDate.of(2024, 1, 31);
        System.out.println(date); // 2024-01-31
        System.out.println(date.plusDays(2));      // 2024-02-02
        System.out.println(date.minusDays(2));// 2024-01-31
        System.out.println(date.plusWeeks(3));   // 2024-02-21
        System.out.println(date.plusMonths(1)); // 2024-02-29
        System.out.println(date.plusYears(2));   // 2026-01-31

        System.out.println(date.plus(2, ChronoUnit.DAYS)); // 2024-02-02
        System.out.println(date.plus(5, ChronoUnit.MONTHS)); // 2024-06-30
    }

    private static void manipulateLocalDateTime() {
        System.out.println("\n##### Local Date Time #####");
        LocalDateTime dateTime = LocalDateTime.of(2024, Month.JANUARY, 31, 10, 39, 45, 5000);
        System.out.println(dateTime.plusDays(2));   // 2024-02-02T10:39:45.000005
        System.out.println(dateTime.plusWeeks(2));  // 2024-02-14T10:39:45.000005
        System.out.println(dateTime.plus(1, ChronoUnit.MONTHS));  // 2024-02-29T10:39:45.000005

        LocalDateTime newDateTime = dateTime.plusYears(5)
                .minusMonths(4)
                .plusWeeks(3)
                .minusDays(2)
                .plusHours(1)
                .minusMinutes(5)
                .plusSeconds(4)
                .minusNanos(3);
        System.out.println(newDateTime);
    }
}
