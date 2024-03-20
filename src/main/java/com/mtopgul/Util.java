package com.mtopgul;

import java.time.LocalDate;
import java.time.temporal.WeekFields;
import java.util.Locale;

/**
 * @author muhammed-topgul
 * @since 15/02/2024 09:20
 */
public final class Util {
    private Util() {
    }

    public static void divide() {
        System.out.println("\n-------------------");
    }

    public static void divide(String title) {
        divide(title, 1);
    }

    public static void divide(String title, int newLineCount) {
        System.out.println("\n".repeat(newLineCount) + "----------" + title + "----------");
    }

    public static void main(String[] args) {
        LocalDate today = LocalDate.now();
        System.out.println("Day of Year = " + today.getDayOfYear());

        int weekOfYear = today.get(WeekFields.of(Locale.getDefault()).weekOfWeekBasedYear());
        System.out.println("Week of Year = " + weekOfYear);
    }
}
