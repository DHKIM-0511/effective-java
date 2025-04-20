package com.nrz.efj.chapter01.item02.freeze;

import java.util.ArrayList;
import java.util.List;

public class Person {

    private final String name;

    private final int birthYear;

    private final List<String> hobby;

    public Person(String name, int birthYear) {
        this.name = name;
        this.birthYear = birthYear;
        this.hobby = new ArrayList<>();
    }

    public static void main(String[] args) {
        Person person = new Person("nrz", 1996);

    }
}
