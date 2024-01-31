package com.mtopgul.coreApis.datesAndTimes.revisited;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.temporal.ChronoUnit;

/**
 * @author muhammed-topgul
 * @since 31/01/2024 22:39
 */
public class LocalDateTimeTruncateTo {
    public static void main(String[] args) {
        LocalTime time = LocalTime.of(3, 12, 45, 1000);
        System.out.println(time);                                 // 03:12:45.000001
        System.out.println(time.truncatedTo(ChronoUnit.SECONDS)); // 03:12:45
        System.out.println(time.truncatedTo(ChronoUnit.MINUTES)); // 03:12
        System.out.println(time.truncatedTo(ChronoUnit.HOURS));   // 03:00
        System.out.println(time.truncatedTo(ChronoUnit.DAYS));    // 00:00
        // System.out.println(time.truncatedTo(ChronoUnit.YEARS));   // Exception

        LocalDate date = LocalDate.of(2024, Month.JANUARY, 31);
        LocalDateTime dateTime = LocalDateTime.of(date, time);
        System.out.println(dateTime);                                 // 2024-01-31T03:12:45.000001
        System.out.println(dateTime.truncatedTo(ChronoUnit.MINUTES)); // 2024-01-31T03:12
        System.out.println(dateTime.truncatedTo(ChronoUnit.HOURS));   // 2024-01-31T03:00

    }
}
