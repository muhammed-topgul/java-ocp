package com.mtopgul;

import java.util.Arrays;

public class ScoreCalculator {
    public static void main(String[] args) {
        int[] options = {
                3,
                3,
                4,
                1,
                2,
                1,
                1,
                1,
                3,
                1,
                1,
                1,
                1,
                3,
                1,
                1,
                2,
                1,
                2,
                3,
                1
        };

        int wrongOptions = 1;
        int sum = Arrays.stream(options).sum();
        double score = ((double) 100 / sum) * (sum - wrongOptions);
        System.out.printf("Score: %.2f", score);
    }
}
