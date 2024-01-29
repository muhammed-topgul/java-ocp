package com.mtopgul.coreApis.array.multidimensionalArray;

import java.util.Arrays;

/**
 * @author muhammed-topgul
 * @since 29/01/2024 08:50
 */
public class CreatingMultidimensionalArray {
    public static void main(String[] args) {
        {
            int[][] vars1; // 2D array
            int vars2[][]; // 2D array
            int[] vars3[]; // 2D array
            int[] vars4[], vars5[][]; // 2D array and 3D array
        }

        {
            String[][] rectangle = new String[3][2];
            int[][] differentSizes = {
                    {1, 4},
                    {3},
                    {9, 8, 7}
            };
            System.out.println(Arrays.deepToString(differentSizes)); // [[1, 4], [3], [9, 8, 7]]
        }

        {
            int[][] array = new int[4][];
            array[0] = new int[2];
            array[1] = new int[3];
            System.out.println(Arrays.deepToString(array)); // [[0, 0], [0, 0, 0], null, null]
        }
    }
}
