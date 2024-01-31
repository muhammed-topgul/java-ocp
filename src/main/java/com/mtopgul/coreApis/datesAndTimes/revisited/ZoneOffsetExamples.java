package com.mtopgul.coreApis.datesAndTimes.revisited;

import java.time.ZoneOffset;

/**
 * @author muhammed-topgul
 * @since 31/01/2024 10:47
 */
public class ZoneOffsetExamples {
    public static void main(String[] args) {
        printOffSetV1("+03:00");
        printOffSetV1("+03:00");
    }

    private static void printOffSetV1(String offsetId) {
        ZoneOffset zoneOffset = ZoneOffset.of(offsetId);
        System.out.println(zoneOffset);
        System.out.println(zoneOffset.getRules());
    }
}
