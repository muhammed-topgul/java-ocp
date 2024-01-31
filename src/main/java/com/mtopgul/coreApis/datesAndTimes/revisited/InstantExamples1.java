package com.mtopgul.coreApis.datesAndTimes.revisited;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalTime;
import java.util.concurrent.TimeUnit;

/**
 * @author muhammed-topgul
 * @since 31/01/2024 23:05
 */
public class InstantExamples1 {
    public static void main(String[] args) throws InterruptedException {
        Instant now = Instant.now();
        TimeUnit.SECONDS.sleep(3);
        Instant later = Instant.now();
        System.out.println(Duration.between(LocalTime.of(1, 1), LocalTime.now())); // PT22H6M32.806427S
        Duration between = Duration.between(now, later);
        System.out.println(between);             // PT3.0089896S
        System.out.println(between.toMillis());  // 3005
        System.out.println(between.toSeconds()); // 3
    }
}
