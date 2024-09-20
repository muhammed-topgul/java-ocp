package com.mtopgul;

import java.util.Arrays;

public class ScoreCalculator {
    public static void main(String[] args) {
        int[] options = {
               2,
               2,
               2,
               4,
               3,
               3,
               2,
               1,
               4,
               1,
               2,
               1,
               1,
               1,
               1,
               1,
               1,
               3,
               3,
               2,
               2,
        };

        int wrongOptions = 2;
        int sum = Arrays.stream(options).sum();
        double score = ((double) 100 / sum) * (sum - wrongOptions);
        System.out.printf("Score: %.2f", score);
    }
}
