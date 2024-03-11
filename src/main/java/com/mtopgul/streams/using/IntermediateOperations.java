package com.mtopgul.streams.using;

import com.mtopgul.Util;

import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

import static com.mtopgul.streams.using.TerminalOperations.primates;

/**
 * @author muhammed-topgul
 * @since 10/03/2024 18:17
 */
public class IntermediateOperations {
    public static void main(String[] args) {
        // filter()
        Util.divide("filter()");
        primates().filter(x -> x.startsWith("M"))
                .forEach(System.out::println);    // Monkey

        // distinct()
        Util.divide("distinct()");
        duckStream()
                .distinct()
                .forEach(System.out::print);     // duckgoose

        Util.divide("distinct()", 2);
        userStream()
                .distinct()
                .forEach(System.out::print);     // user-1user-2user-3


        // limit() skip()
        Util.divide("limit() skip()", 2);
        Stream<Integer> infinitiveStream = Stream.iterate(1, n -> n + 1);
        infinitiveStream
                .skip(5)
                .limit(2)
                .forEach(System.out::print); // 67


        // map()
        Util.divide("map()", 2);
        primates().map(String::length)
                .forEach(System.out::print);  // 6763

        // flatMap()
        Util.divide("flatMap()", 2);
        List<String> zero = List.of();
        var one = List.of("Bonobo");
        var two = List.of("Mama Gorilla", "Baby Gorilla");
        Stream<List<String>> animals = Stream.of(zero, one, two);
        animals.flatMap(list -> list.stream())
                .forEach(System.out::println);
        /*
        Bonobo
        Mama Gorilla
        Baby Gorilla
         */

        // concat()
        Util.divide("concat()", 2);
        var s1 = Stream.of("Bonobo");
        var s2 = Stream.of("Mama Gorilla", "Baby Gorilla");
        Stream.concat(s1, s2)
                .forEach(System.out::println);
        /*
        Bonobo
        Mama Gorilla
        Baby Gorilla
         */


        // sorted()
        Util.divide("sorted()", 2);
        charStream()
                .sorted()
                .forEach(System.out::print);  // abcd
        System.out.println();
        charStream()
                .sorted(Comparator.reverseOrder())
                .forEach(System.out::print);  // dcba


        // peek()
        Util.divide("peek()", 2);
        long count = primates().filter(p -> p.contains("e"))
                .peek(System.out::println) // Monkey Ape
                .count(); // 2
        System.out.println(count);
    }

    private static Stream<User> userStream() {
        User u1 = new User("user-1");
        User u2 = new User("user-1");
        User u3 = new User("user-2");
        User u4 = new User("user-2");
        User u5 = new User("user-3");
        return Stream.of(u1, u2, u3, u4, u5);
    }

    private static Stream<String> charStream() {
        return Stream.of("a", "b", "c", "d");
    }

    private static Stream<String> duckStream() {
        return Stream.of("duck", "duck", "duck", "goose");
    }

    private static class User {
        private final String name;

        public User(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        @Override
        public boolean equals(Object object) {
            if (this == object) return true;
            if (object == null || getClass() != object.getClass()) return false;
            User user = (User) object;
            return Objects.equals(name, user.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name);
        }

        @Override
        public String toString() {
            return name;
        }
    }
}
