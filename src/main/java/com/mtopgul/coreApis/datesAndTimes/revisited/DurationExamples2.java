package com.mtopgul.coreApis.datesAndTimes.revisited;

import java.time.*;

/**
 * @author muhammed-topgul
 * @since 31/01/2024 22:46
 */
public class DurationExamples2 {
    public static void main(String[] args) {
        LocalDate date = LocalDate.of(2024, 1, 20);
        LocalTime time = LocalTime.of(6, 15);
        LocalDateTime dateTime = LocalDateTime.of(date, time);

        Duration duration1 = Duration.ofHours(23);
        Duration duration2 = Duration.ofDays(2);
        Period period1 = Period.ofWeeks(3);
        Period period2 = Period.ofMonths(2);

        // System.out.println(date.plus(duration1)); // Exception
        System.out.println(date.plus(period1)); // 2024-02-10
        System.out.println(date.plus(period2)); // 2024-03-20

        System.out.println(time.plus(duration1)); // 05:15
        System.out.println(time.plus(duration2)); // 06:15

        System.out.println(dateTime.plus(duration1)); // 2024-01-21T05:15
        System.out.println(dateTime.plus(duration2)); // 2024-01-22T06:15
        System.out.println(dateTime.plus(period1));   // 2024-02-10T06:15
        System.out.println(dateTime.plus(period2));   // 2024-03-20T06:15

    }
}
