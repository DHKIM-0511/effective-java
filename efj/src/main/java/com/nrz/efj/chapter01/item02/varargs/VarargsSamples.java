package com.nrz.efj.chapter01.item02.varargs;

import java.util.Arrays;

public class VarargsSamples {
    public void printNumbers(int... numbers) {
        System.out.println(numbers.getClass().getCanonicalName()); // int[]
        System.out.println(numbers.getClass().getComponentType()); // int
        Arrays.stream(numbers).forEach(System.out::println);
    }

    public static void main(String[] args) {
        VarargsSamples samples = new VarargsSamples();
        samples.printNumbers(1, 20, 20, 39, 59);
    }
}
