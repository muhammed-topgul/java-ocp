package com.mtopgul.coreApis.datesAndTimes.revisited;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;

/**
 * @author muhammed-topgul
 * @since 31/01/2024 23:09
 */
public class InstantExamples2 {
    public static void main(String[] args) {
        ZonedDateTime zonedDateTime = ZonedDateTime.of(2024, 1, 31, 15, 30, 25, 1, ZoneId.of("Europe/Istanbul"));
        Instant instant = zonedDateTime.toInstant();
        System.out.println(zonedDateTime);                            // 2024-01-31T15:30:25.000000001+03:00[Europe/Istanbul]
        System.out.println(instant);                                  // 2024-01-31T12:30:25.000000001Z
        System.out.println(instant.truncatedTo(ChronoUnit.MINUTES));  // 2024-01-31T12:30:00Z
        System.out.println(instant.truncatedTo(ChronoUnit.HOURS));    // 2024-01-31T12:00:00Z
        System.out.println(instant.truncatedTo(ChronoUnit.DAYS));     // 2024-01-31T00:00:00Z
    }
}
