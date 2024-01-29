package com.mtopgul.coreApis.datesAndTimes;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.ZoneId;
import java.time.ZonedDateTime;

/**
 * @author muhammed-topgul
 * @since 29/01/2024 09:47
 */
public class CreatingDatesAndTimes {
    public static void main(String[] args) {
        {
            System.out.println(LocalDate.now());      // 2024-01-29
            System.out.println(LocalTime.now());      // 09:48:30.3615
            System.out.println(LocalDateTime.now());  // 2024-01-09T09:48:30.3615
            System.out.println(ZonedDateTime.now());  // 2024-01-29T09:48:30.3615+03:00[Europe/Istanbul]
        }

        {
            var date1 = LocalDate.of(2024, Month.JANUARY, 29);
            var date2 = LocalDate.of(2024, 1, 29);
            System.out.println(date1);
            System.out.println(date2);
        }

        {
            var time1 = LocalTime.of(6, 15); // hour and minute
            var time2 = LocalTime.of(6, 15, 30); // + seconds
            var time3 = LocalTime.of(6, 15, 30, 200);  // + milliseconds
            System.out.println(time1);
            System.out.println(time2);
            System.out.println(time3);
        }

        {
            var dateTime1 = LocalDateTime.of(2024, Month.JANUARY, 20, 6, 15, 30); // 2024-01-20T06:15:30
            System.out.println(dateTime1);
            var dateTime2 = LocalDateTime.of(LocalDate.of(2024, Month.JANUARY, 29), LocalTime.of(10, 6, 56, 158));
            System.out.println(dateTime2);
        }

        {
            ZoneId zone = ZoneId.of("Europe/Istanbul");
            var zonedTime1 = ZonedDateTime.of(2024, 1, 29, 11, 47, 25, 458, zone);
            System.out.println(zonedTime1);

            LocalDate date = LocalDate.of(2024, Month.JANUARY, 29);
            LocalTime time = LocalTime.of(10, 6, 56, 158);
            ZonedDateTime zonedTime2 = ZonedDateTime.of(date, time, zone);
            System.out.println(zonedTime2);

            LocalDateTime localDateTime = LocalDateTime.of(date, time);
            ZonedDateTime zonedTime3 = ZonedDateTime.of(localDateTime, zone);
            System.out.println(zonedTime3);
        }

        {
            var d = LocalDate.of(2022, Month.JANUARY, 32); // DateTimeException
        }
    }
}
