package com.mtopgul.streams.primitive;

import java.util.IntSummaryStatistics;
import java.util.stream.IntStream;

/**
 * @author muhammed-topgul
 * @since 11/03/2024 10:39
 */
public class SummarizingStatistics {
    public static void main(String[] args) {
        range(IntStream.range(0, 56));
    }

    private static void range(IntStream ints) {
        IntSummaryStatistics stats = ints.summaryStatistics();
        if (stats.getCount() == 0) {
            throw new RuntimeException();
        }
        System.out.println("Count: " + stats.getCount());
        System.out.println("Average: " + stats.getAverage());
        System.out.println("Sum: " + stats.getSum());
        System.out.println("Min: " + stats.getMin());
        System.out.println("Max: " + stats.getMax());
    }
}
