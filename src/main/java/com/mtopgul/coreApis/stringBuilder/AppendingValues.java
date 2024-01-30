package com.mtopgul.coreApis.stringBuilder;

/**
 * @author muhammed-topgul
 * @since 30/01/2024 10:16
 */
public class AppendingValues {
    public static void main(String[] args) {
        var sb = new StringBuilder().append(1).append('c');
        sb.append("-").append(true);

        // sb.append(null); // DOES NOT COMPILE
        sb.append((String) null);

        System.out.println(sb); //1c-truenull
    }
}
