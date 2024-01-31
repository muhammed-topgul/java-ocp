package com.mtopgul.coreApis.datesAndTimes.revisited;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;

/**
 * @author muhammed-topgul
 * @since 31/01/2024 12:06
 */
public class PeriodExamples3 {
    public static void main(String[] args) {
        LocalDate date = LocalDate.of(2024, 1, 31);
        LocalTime time = LocalTime.of(10, 39);
        LocalDateTime dateTime = LocalDateTime.of(date, time);

        Period threeMonths = Period.ofMonths(3);
        System.out.println(date.plus(threeMonths));     // 2024-04-30
        System.out.println(dateTime.plus(threeMonths)); // 2024-04-30T10:39
        System.out.println(time.plus(threeMonths));     // Exception
    }
}
