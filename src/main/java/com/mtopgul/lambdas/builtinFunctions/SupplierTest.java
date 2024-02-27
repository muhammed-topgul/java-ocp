package com.mtopgul.lambdas.builtinFunctions;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.function.Supplier;

/**
 * @author muhammed-topgul
 * @since 27/02/2024 18:56
 */
public class SupplierTest {
    public static void main(String[] args) {
        {
            Supplier<LocalDate> supplier1 = new Supplier<LocalDate>() {
                @Override
                public LocalDate get() {
                    return LocalDate.now();
                }
            };

            Supplier<LocalDate> supplier2 = () -> LocalDate.now();
            Supplier<LocalDate> supplier3 = LocalDate::now;

            System.out.println(supplier1.get());
            System.out.println(supplier2.get());
            System.out.println(supplier3.get());
        }

        {
            Supplier<StringBuilder> supplier1 = () -> new StringBuilder();
            Supplier<StringBuilder> supplier2 = StringBuilder::new;
            System.out.println(supplier1.get());
            System.out.println(supplier2.get());
        }

        {
            Supplier<ArrayList<String>> supplier1 = ArrayList::new;
            Supplier<ArrayList<String>> supplier2 = () -> new ArrayList<>();
            System.out.println(supplier1.get());
            System.out.println(supplier2.get());
        }

        {
            Supplier<?> supplier1 = () -> "Java";
            Supplier<?> supplier2 = String::new;
            System.out.println(supplier1.get());
            System.out.println(supplier2.get());
        }
    }
}
