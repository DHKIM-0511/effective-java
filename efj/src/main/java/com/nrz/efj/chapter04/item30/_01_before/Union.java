package com.nrz.efj.chapter04.item30._01_before;

import java.util.HashSet;
import java.util.Set;

public class Union {
    public static <E> Set<E> union(Set<E> s1, Set<E> s2){
        Set<E> result = new HashSet<>(s1);
        result.addAll(s2);
        return  result;
    }

    public static void main(String[] args){
        Set<String> guy = Set.of("톰","딕","해리");
        Set<String> sooges = Set.of("1","2","3");
        Set<String> all = union(guy, sooges);

        for( String o : all){
            System.out.println(o);
        }
    }
}
