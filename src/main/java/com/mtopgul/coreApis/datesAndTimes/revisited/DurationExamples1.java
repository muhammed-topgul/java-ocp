package com.mtopgul.coreApis.datesAndTimes.revisited;

import java.time.Duration;
import java.time.temporal.ChronoUnit;

/**
 * @author muhammed-topgul
 * @since 31/01/2024 22:24
 */
public class DurationExamples1 {
    public static void main(String[] args) {
        System.out.println(Duration.ofDays(1));     // PT24H
        System.out.println(Duration.ofHours(12));   // PT12H
        System.out.println(Duration.ofMinutes(56)); // PT56M
        System.out.println(Duration.ofSeconds(10)); // PT10S
        System.out.println(Duration.ofMillis(10));  // PT0.1S
        System.out.println(Duration.ofNanos(10));   // PT0.00000001S

        System.out.println();

        System.out.println(Duration.of(1, ChronoUnit.DAYS));     // PT24H
        System.out.println(Duration.of(12, ChronoUnit.HOURS));   // PT12H
        System.out.println(Duration.of(56, ChronoUnit.MINUTES)); // PT56M
        System.out.println(Duration.of(10, ChronoUnit.SECONDS)); // PT10S
        System.out.println(Duration.of(10, ChronoUnit.MILLIS));  // PT0.1S
        System.out.println(Duration.of(10, ChronoUnit.NANOS));   // PT0.00000001S
    }
}
