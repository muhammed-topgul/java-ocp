package com.mtopgul.streams.optional;

import java.util.Optional;

/**
 * @author muhammed-topgul
 * @since 07/03/2024 13:13
 */
public class CommonInstanceMethods {
    public static void main(String[] args) {
        // get()
        // System.out.println(emptyOpt().get()); // NoSuchElementException
        System.out.println(nonEmptyOpt().get()); // Java

        // ifPresent()
        emptyOpt().ifPresent(System.out::println);    // Nothing to print
        nonEmptyOpt().ifPresent(System.out::println); // Java

        // orElse()
        System.out.println(emptyOpt().orElse("No data"));    // No data
        System.out.println(nonEmptyOpt().orElse("No data")); // Java

        // orElseGet()
        System.out.println(emptyOpt().orElseGet(() -> "New data"));    // New data
        System.out.println(nonEmptyOpt().orElse("New data"));   // Java

        // orElseThrow()
        // System.out.println(emptyOpt().orElseThrow());  // NoSuchElementException
        System.out.println(nonEmptyOpt().orElseThrow());  // Java

        System.out.println(nonEmptyOpt().orElseThrow(RuntimeException::new)); // Java
        System.out.println(emptyOpt().orElseThrow(() -> new RuntimeException("My exception")));
    }

    private static Optional<String> emptyOpt() {
        return Optional.empty();
    }

    private static Optional<String> nonEmptyOpt() {
        return Optional.of("Java");
    }
}
