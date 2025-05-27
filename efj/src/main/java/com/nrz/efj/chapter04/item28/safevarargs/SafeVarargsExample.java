package com.nrz.efj.chapter04.item28.safevarargs;

import java.util.List;

public class SafeVarargsExample {
    static void notSafe(List<String>... stringLists){
        Object[] array = stringLists;
        List<Integer>tmpList = List.of(42);
        array[0] = tmpList;
        String s= stringLists[0].get(0); // class cast exception 런타임에 발생함
    }

    @SafeVarargs
    static <T> void safe(T... values){
        for(T value: values){
            System.out.println(value);
        }
    }

    public static void main(String[] args) {
        SafeVarargsExample.safe("a", "b", "c");
        SafeVarargsExample.notSafe(List.of("a", "b", "c"));
    }
}
