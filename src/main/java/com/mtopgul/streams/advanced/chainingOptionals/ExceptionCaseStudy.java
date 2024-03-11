package com.mtopgul.streams.advanced.chainingOptionals;

import java.io.IOException;
import java.util.List;
import java.util.function.Supplier;

/**
 * @author muhammed-topgul
 * @since 11/03/2024 12:58
 */
public class ExceptionCaseStudy {
    public static void main(String[] args) {

    }

    private static List<String> create() throws IOException {
        throw new IOException();
    }

    private static List<String> createSafe() {
        try {
            return ExceptionCaseStudy.create();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void good() throws IOException {
        ExceptionCaseStudy.create().stream().count();
    }

    public void bad() throws IOException {
        // Supplier<List<String>> supplier = () -> ExceptionCaseStudy.create(); // DOES NOT COMPILE
        // Supplier<List<String>> supplier = ExceptionCaseStudy::create; // DOES NOT COMPILE
    }

    public void ugly() {
        Supplier<List<String>> supplier = () -> {
            try {
                return ExceptionCaseStudy.create();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        };
    }

    public void wrapped() {
        Supplier<List<String>> supplier = ExceptionCaseStudy::createSafe;
    }
}
