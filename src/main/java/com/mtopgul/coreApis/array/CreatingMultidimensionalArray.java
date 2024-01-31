package com.mtopgul.coreApis.array;

import java.util.Arrays;

/**
 * @author muhammed-topgul
 * @since 31/01/2024 08:35
 */
public class CreatingMultidimensionalArray {
    public static void main(String[] args) {
        int[][] vars1;            // 2D array
        int vars2[][];            // 2D array
        int[] vars3[];           // 2D array
        int[] vars4[], space[][]; // 2D and 3D array

        String[][] rectangle = new String[3][2];
        rectangle[0][1] = "set";
        System.out.println(Arrays.deepToString(rectangle));

        int[][] differentSizes = {
                {1, 4},
                {3},
                {9, 8, 7}
        };
        System.out.println(Arrays.deepToString(differentSizes));

        int[][] jagged = new int[3][];
        jagged[0] = new int[1];
        jagged[1] = new int[3];
        jagged[2] = new int[2];
    }
}
