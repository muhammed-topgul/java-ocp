package com.mtopgul.coreApis.datesAndTimes.revisited;

import java.time.LocalDate;
import java.time.Month;
import java.time.Period;

/**
 * @author muhammed-topgul
 * @since 31/01/2024 11:52
 */
public class PeriodExamples1 {
    public static void main(String[] args) {
        LocalDate start = LocalDate.of(2024, Month.JANUARY, 1);
        LocalDate end = LocalDate.of(2024, Month.MARCH, 30);
        performAnimalEnrichment(start, end);
        performAnimalEnrichment(start, end, Period.ofMonths(1));
    }

    private static void performAnimalEnrichment(LocalDate start, LocalDate end) {
        var upto = start;
        while (upto.isBefore(end)) {
            System.out.println("Give new toy: " + upto);
            upto = upto.plusMonths(1);
        }
    }

    private static void performAnimalEnrichment(LocalDate start, LocalDate end, Period period) {
        var upto = start;
        while (upto.isBefore(end)) {
            System.out.println("Give new toy: " + upto);
            upto = upto.plus(period);
        }
    }
}
