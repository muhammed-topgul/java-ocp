package com.mtopgul.coreApis.datesAndTimes;

import java.time.LocalDate;
import java.time.Month;
import java.time.Period;

/**
 * @author muhammed-topgul
 * @since 29/01/2024 13:26
 */
public class WorkingWithPeriods {
    public static void main(String[] args) {
        var start = LocalDate.of(2024, Month.JANUARY, 1);
        var end = LocalDate.of(2024, Month.MARCH, 1);
        performAnimalEnrichment(start, end);

        performAnimalEnrichment(start, end, Period.ofMonths(1)); // every 1 month
        performAnimalEnrichment(start, end, Period.ofDays(3));   // every 3 days
        performAnimalEnrichment(start, end, Period.ofWeeks(3));  // every 3 weeks
        performAnimalEnrichment(start, end, Period.ofYears(1));  // every 1 year

        end = LocalDate.of(2026, Month.MAY, 15);
        performAnimalEnrichment(start, end, Period.of(1, 2, 7)); // every year, 2 month and 7 days
    }

    private static void performAnimalEnrichment(LocalDate start, LocalDate end) {
        var upTo = start;
        while (upTo.isEqual(end) || upTo.isBefore(end)) {
            System.out.println("Give new toy: " + upTo);
            upTo = upTo.plusMonths(1);
        }
        System.out.println("---------------------------");
    }

    private static void performAnimalEnrichment(LocalDate start, LocalDate end, Period period) {
        var upTo = start;
        while (upTo.isEqual(end) || upTo.isBefore(end)) {
            System.out.println("Give new toy: " + upTo);
            upTo = upTo.plus(period);
        }
        System.out.println("---------------------------");
    }
}
