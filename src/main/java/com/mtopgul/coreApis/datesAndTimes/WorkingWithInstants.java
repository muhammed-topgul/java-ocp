package com.mtopgul.coreApis.datesAndTimes;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.concurrent.TimeUnit;

/**
 * @author muhammed-topgul
 * @since 29/01/2024 14:55
 */
public class WorkingWithInstants {
    public static void main(String[] args) throws InterruptedException {
        {
            Instant now = Instant.now();
            TimeUnit.SECONDS.sleep(2);
            var later = Instant.now();
            Duration between = Duration.between(now, later);
            System.out.println(between);             // PT2.0065636S
            System.out.println(between.toNanos());   // 2006563600
            System.out.println(between.toMillis());  // 2006
            System.out.println(between.toSeconds()); // 2
        }

        {
            var date = LocalDate.of(2022, 5, 25);
            var time = LocalTime.of(11, 55, 0);
            var zone = ZoneId.of("Europe/Istanbul");
            ZonedDateTime zonedDateTime = ZonedDateTime.of(date, time, zone);
            Instant instant = zonedDateTime.toInstant();
            System.out.println(zonedDateTime); // 2022-05-25T11:55+03:00[Europe/Istanbul]
            System.out.println(instant);       // 2022-05-25T08:55:00Z
        }
    }
}
