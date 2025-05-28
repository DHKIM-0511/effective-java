package com.nrz.efj.chapter04.item31;

import java.util.HashSet;
import java.util.Set;

public class Union {
    public static <E> Set<E> union(Set<? extends E> s1, Set<? extends E> s2){
        Set<E> result = new HashSet<>(s1);
        result.addAll(s2);
        return  result;
    }

    public static void main(String[] args){
        Set<Integer> integers = new HashSet<>();
        integers.add(1);
        integers.add(2);
        integers.add(3);

        Set<Double> doubles = new HashSet<>();
        doubles.add(1.1);
        doubles.add(2.2);
        doubles.add(3.3);

        Set<Number> all = union(integers, doubles);

        for( Number o : all){
            System.out.println(o);
        }
    }
}
