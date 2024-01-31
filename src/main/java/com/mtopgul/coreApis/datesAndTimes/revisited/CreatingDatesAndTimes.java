package com.mtopgul.coreApis.datesAndTimes.revisited;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

/**
 * @author muhammed-topgul
 * @since 31/01/2024 09:45
 */
public class CreatingDatesAndTimes {
    public static void main(String[] args) {
        basics();
        localDate();
        localTime();
        localDateTime();
        zonedDateTime();
    }

    private static void basics() {
        System.out.println("###### Basics ######");
        System.out.println(LocalTime.now());       // 09:46:43.297012400
        System.out.println(LocalDate.now());       // 2024-01-31
        System.out.println(LocalDateTime.now());   // 2024-01-31T09:46:43.298013400
        System.out.println(ZonedDateTime.now());   // 2024-01-31T09:46:43.299014600+03:00[Europe/Istanbul]
        System.out.println(OffsetDateTime.now());  // 2024-01-31T09:46:43.299014600+03:00
    }

    private static void localDate() {
        System.out.println("\n###### Local Date ######");
        LocalDate today1 = LocalDate.now();  // 2024-01-31
        LocalDate today2 = LocalDate.of(2024, Month.JANUARY, 31);
        LocalDate today3 = LocalDate.of(2024, 1, 31);
        // LocalDate invalid = LocalDate.of(2024, 5, 32); // DateTimeException

        System.out.println(today1);
        System.out.println(today2);
        System.out.println(today3);
    }

    private static void localTime() {
        System.out.println("\n###### Local Time ######");
        LocalTime now1 = LocalTime.now();  // 10:23:37.785386100
        LocalTime now2 = LocalTime.of(10, 23);
        LocalTime now3 = LocalTime.of(10, 23, 31);
        LocalTime now4 = LocalTime.of(10, 23, 31, 450);

        System.out.println(now1);
        System.out.println(now2);
        System.out.println(now3);
        System.out.println(now4);
    }

    private static void localDateTime() {
        System.out.println("\n###### Local Date Time ######");
        LocalDateTime now1 = LocalDateTime.now();
        LocalDateTime usEastern = LocalDateTime.now(ZoneId.of("US/Eastern"));
        LocalDateTime now2 = LocalDateTime.of(2024, Month.JANUARY, 31, 10, 29);
        LocalDateTime now3 = LocalDateTime.of(2024, Month.JANUARY, 31, 10, 39, 25);
        LocalDateTime now4 = LocalDateTime.of(2024, Month.JANUARY, 31, 10, 39, 25, 48555220);
        LocalDateTime now5 = LocalDateTime.of(2024, 1, 31, 10, 29);
        LocalDateTime now6 = LocalDateTime.of(LocalDate.now(), LocalTime.now());

        System.out.println(now1);
        System.out.println(usEastern);
        System.out.println(now2);
        System.out.println(now3);
        System.out.println(now4);
        System.out.println(now5);
        System.out.println(now6);
    }

    private static void zonedDateTime() {
        System.out.println("\n###### Zoned Date Time ######");
        LocalDate date1 = LocalDate.of(2024, Month.JANUARY, 31);
        LocalTime time1 = LocalTime.of(10, 34);
        LocalDateTime localDateTime = LocalDateTime.of(date1, time1);
        ZoneId zone = ZoneId.of("US/Eastern");

        ZonedDateTime now1 = ZonedDateTime.now();
        ZonedDateTime now2 = ZonedDateTime.of(2024, 1, 31, 10, 39, 54, 4500000, zone);
        ZonedDateTime now3 = ZonedDateTime.of(date1, time1, zone);
        ZonedDateTime now4 = ZonedDateTime.of(localDateTime, zone);

        System.out.println(now1);
        System.out.println(now2);
        System.out.println(now3);
        System.out.println(now4);
    }
}
