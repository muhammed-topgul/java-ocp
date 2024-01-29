package com.mtopgul.coreApis.datesAndTimes;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

/**
 * @author muhammed-topgul
 * @since 29/01/2024 13:52
 */
public class WorkingWithDurations {
    public static void main(String[] args) {
        {
            System.out.println(Duration.ofDays(1));     // PT24H
            System.out.println(Duration.ofHours(2));    // PT2H
            System.out.println(Duration.ofMinutes(1));  // PT1M
            System.out.println(Duration.ofSeconds(10)); // PT10S
            System.out.println(Duration.ofMillis(1));   // PT0.001S
            System.out.println(Duration.ofNanos(1));    // PT0.000000001S
        }

        {
            System.out.println(Duration.of(1, ChronoUnit.DAYS));      // PT24H
            System.out.println(Duration.of(1, ChronoUnit.HOURS));     // PT1H
            System.out.println(Duration.of(1, ChronoUnit.MINUTES));   // PT1M
            System.out.println(Duration.of(1, ChronoUnit.SECONDS));   // PT1S
            System.out.println(Duration.of(1, ChronoUnit.MILLIS));    // PT0.001S
            System.out.println(Duration.of(1, ChronoUnit.NANOS));     // PT0.000000001S
            System.out.println(Duration.of(1, ChronoUnit.HALF_DAYS)); // PT12H
        }

        {
            var date = LocalDate.of(2022, 1, 20);
            var time = LocalTime.of(6, 15);
            var dateTime = LocalDateTime.of(date, time);
            var duration = Duration.ofHours(6);
            System.out.println(dateTime.plus(duration)); // 2022–01–20T12:15
            System.out.println(time.plus(duration)); // 12:15
            System.out.println(date.plus(duration)); // UnsupportedTemporalTypeException
        }
    }
}
