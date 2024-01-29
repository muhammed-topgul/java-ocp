package com.mtopgul.coreApis.datesAndTimes;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

/**
 * @author muhammed-topgul
 * @since 29/01/2024 14:25
 */
public class ChronoUnitForDifferences {
    public static void main(String[] args) {
        {
            var time1 = LocalTime.of(5, 15);
            var time2 = LocalTime.of(6, 30);
            var date1 = LocalDate.of(2016, 1, 20);
            var date2 = LocalDate.of(2018, 1, 20);
            System.out.println(ChronoUnit.HOURS.between(time1, time2));   // 1
            System.out.println(ChronoUnit.MINUTES.between(time1, time2)); // 75
            // System.out.println(ChronoUnit.MINUTES.between(time1, date1));  // Exception
            System.out.println(ChronoUnit.DAYS.between(date1, date2));  // 731
        }

        {
            LocalTime time = LocalTime.of(3, 12, 45, 75);
            System.out.println(time);                                 // 03:12:45:000000075
            System.out.println(time.truncatedTo(ChronoUnit.SECONDS)); // 03:12:45
            System.out.println(time.truncatedTo(ChronoUnit.MINUTES)); // 03:12
            System.out.println(time.truncatedTo(ChronoUnit.HOURS));   // 03:00
        }
    }
}
