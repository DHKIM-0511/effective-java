package com.nrz.efj.chapter01.item03.functionalinterface;

import com.nrz.efj.chapter01.item03.methodreference.Person;
import java.time.LocalDate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class DefaultFunctions {
    public static void main(String[] args) {
        Function<Integer, String> intToString = (i) -> "hi"+i;

        Supplier<Person> personSupplier = Person::new;
        Function<LocalDate, Person> personFunction = Person::new;

        Consumer<Integer> integerConsumer = System.out::println;

        Predicate<Integer> predicate;
    }
}
