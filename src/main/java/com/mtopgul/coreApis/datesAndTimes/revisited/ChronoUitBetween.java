package com.mtopgul.coreApis.datesAndTimes.revisited;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

/**
 * @author muhammed-topgul
 * @since 31/01/2024 22:32
 */
public class ChronoUitBetween {
    public static void main(String[] args) {
        LocalTime one = LocalTime.of(5, 15);
        LocalTime two = LocalTime.of(6, 30);
        LocalDate date1 = LocalDate.of(2016, 1, 20);
        LocalDate date2 = LocalDate.of(2016, 1, 22);
        LocalDate date3 = LocalDate.of(2017, 1, 20);

        System.out.println(ChronoUnit.HOURS.between(one, two));     // 1
        System.out.println(ChronoUnit.MINUTES.between(one, two));   // 75
        // System.out.println(ChronoUnit.MINUTES.between(one, date1)); // Exception

        System.out.println(ChronoUnit.DAYS.between(date1, date2));   // 2
        System.out.println(ChronoUnit.DAYS.between(date2, date1));   // -2
        System.out.println(ChronoUnit.DAYS.between(date1, date3));   // 366
        System.out.println(ChronoUnit.MONTHS.between(date1, date2)); // 0
        System.out.println(ChronoUnit.MONTHS.between(date1, date3)); // 12
    }
}
