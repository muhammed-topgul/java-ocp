package com.mtopgul.coreApis.datesAndTimes.revisited;

import java.time.*;

/**
 * @author muhammed-topgul
 * @since 31/01/2024 23:17
 */
public class DaylightSavingTime {
    public static void main(String[] args) {
        LocalDate date = LocalDate.of(2022, Month.MARCH, 13);
        LocalTime time = LocalTime.of(1, 30);
        ZoneId zone = ZoneId.of("US/Eastern");
        ZonedDateTime dateTime = ZonedDateTime.of(date, time, zone);
        System.out.println(dateTime);              // 2022-03-13T01:30-05:00[US/Eastern]
        System.out.println(dateTime.getHour());    // 1
        System.out.println(dateTime.getOffset());  // -05:00

        dateTime = dateTime.plusHours(1);
        System.out.println(dateTime);             // 2022-03-13T03:30-04:00[US/Eastern]
        System.out.println(dateTime.getHour());   // 3
        System.out.println(dateTime.getOffset()); // -04:00
    }
}
