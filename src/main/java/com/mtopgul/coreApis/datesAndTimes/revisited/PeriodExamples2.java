package com.mtopgul.coreApis.datesAndTimes.revisited;

import java.time.Period;

/**
 * @author muhammed-topgul
 * @since 31/01/2024 11:58
 */
public class PeriodExamples2 {
    public static void main(String[] args) {
        var annually = Period.ofYears(1);
        var everyThreeMonths = Period.ofMonths(3);
        var everyThreeWeeks = Period.ofWeeks(3);
        var everyDays = Period.ofDays(1);
        var everyYearAndWeeks = Period.of(1, 1, 7);

        System.out.println(annually);           // P1Y
        System.out.println(everyThreeMonths);   // P3M
        System.out.println(everyThreeWeeks);    // P21D
        System.out.println(everyDays);          // P1D
        System.out.println(everyYearAndWeeks);  // P1Y1M7D
    }
}
