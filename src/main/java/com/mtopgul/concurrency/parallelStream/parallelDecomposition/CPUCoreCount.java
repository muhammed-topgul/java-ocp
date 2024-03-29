package com.mtopgul.concurrency.parallelStream.parallelDecomposition;

/**
 * @author muhammed-topgul
 * @since 29/03/2024 13:56
 */
public class CPUCoreCount {
    public static void main(String[] args) {
        int cores = Runtime.getRuntime().availableProcessors();
        System.out.println(cores);
    }
}
