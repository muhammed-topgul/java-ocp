package com.mtopgul.coreApis.datesAndTimes;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.Period;

/**
 * @author muhammed-topgul
 * @since 29/01/2024 13:12
 */
public class ManipulatingDatesAndTimes {
    public static void main(String[] args) {
        {
            var date = LocalDate.of(2024, Month.JANUARY, 29);
            System.out.println(date); // 2024-01-29

            date = date.plusDays(2);
            System.out.println(date); // 2024-01-31

            date = date.plusWeeks(4);
            System.out.println(date); // 2024-02-28

            date = date.plusMonths(1);
            System.out.println(date); // 2024-03-28

            date = date.plusYears(5);
            System.out.println(date); // 2029-03-28
        }

        {
            var date = LocalDate.of(2024, Month.JANUARY, 29);
            var time = LocalTime.of(5, 15);
            var dateTime = LocalDateTime.of(date, time);
            System.out.println(dateTime);
            dateTime = dateTime.minusDays(1);
            System.out.println(dateTime);
            dateTime = dateTime.minusHours(10);
            System.out.println(dateTime);
            dateTime = dateTime.minusSeconds(30);
            System.out.println(dateTime);
        }

        {
            var date = LocalDate.of(2024, Month.JANUARY, 29);
            var time = LocalTime.of(5, 15);
            var dateTime = LocalDateTime.of(date, time)
                    .minusDays(1)
                    .minusHours(10)
                    .minusSeconds(30);
            System.out.println(dateTime);
        }

        {
            // Method Chain not available on Period class
            var wrong = Period.ofYears(1).ofWeeks(1); // every week
            wrong = Period.ofWeeks(1); // These are equals
        }

        {
            // 1 year 2 months 3 days
            System.out.println(Period.of(1, 2, 3)); // P1Y2M3D
            System.out.println(Period.ofDays(5));   // P5D
            System.out.println(Period.ofWeeks(2));  // P14D
            System.out.println(Period.ofMonths(3)); // P3M
            System.out.println(Period.ofYears(2));  // P2Y
        }

        {
            var date = LocalDate.of(2024, 1, 29);
            var time = LocalTime.of(6, 15);
            var dateTime = LocalDateTime.of(date, time);
            var period = Period.ofMonths(1);

            System.out.println(date.plus(period));     // 2024-02-29
            System.out.println(dateTime.plus(period)); // 2024-02-29T06:15
            System.out.println(time.plus(period));     // Exception
        }
    }
}
