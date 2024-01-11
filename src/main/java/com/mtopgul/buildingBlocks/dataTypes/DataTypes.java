package com.mtopgul.buildingBlocks.dataTypes;

/**
 * @author muhammed-topgul
 * @since 11/01/2024 07:17
 */
public class DataTypes {
    public static void main(String[] args) {
        String textBlock = """
                "Java Study Guide"
                      by Scott & Jeanne""";
        System.out.println(textBlock);

        String pyramid = """
                  \"""
                  \s
                  *
                 ***
                *****""";
        System.out.println(pyramid);

        // String block = """doe"""; // DOES NOT COMPILE

        {
            String block = """
                    doe \
                    deer
                    """;
            System.out.println(block); // doe deer
        }

        {
            String block = """
                    doe \n
                    deer
                    """;
            System.out.println(block); // 4 lines of
        }

        {
            String block = """
                     "doe\"\"\"
                     \"deer\"""
                    """;
            System.out.print("*" + block + "*");
        }
    }
}
