package com.mtopgul.coreApis.datesAndTimes.revisited;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.zone.ZoneRules;
import java.util.Set;

/**
 * @author muhammed-topgul
 * @since 31/01/2024 10:39
 */
public class ZoneIdExamples {
    public static void main(String[] args) {
        Set<String> zoneIds = ZoneId.getAvailableZoneIds();
        System.out.println("System Default Zone: " + ZoneId.systemDefault());
        System.out.println("Total Zone Ids: " + zoneIds.size());
        for (String zoneId : zoneIds) {
            System.out.println(zoneId);
        }

        printDayLightSaving(ZoneId.of("US/Eastern"));
        printDayLightSaving(ZoneId.of("Europe/Berlin"));
        printDayLightSaving(ZoneId.of("Europe/Istanbul"));
        printDayLightSaving(ZoneId.of("America/Chicago"));
        printDayLightSaving(ZoneId.of("Asia/Kolkata"));
    }

    private static void printDayLightSaving(ZoneId zoneId) {
        System.out.println("\n####################");
        System.out.println(zoneId);
        ZoneRules zoneRules = zoneId.getRules();
        System.out.println(zoneRules);
        boolean isDaylightSavings = zoneRules.isDaylightSavings(Instant.now());
        System.out.println("Is day light saving day: " + isDaylightSavings);
        System.out.println("Next transition: " + zoneRules.nextTransition(Instant.now()));
        System.out.println("Offset: " + zoneRules.getOffset(LocalDateTime.now()));
    }
}
