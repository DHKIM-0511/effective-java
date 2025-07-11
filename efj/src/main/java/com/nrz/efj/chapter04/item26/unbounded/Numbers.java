package com.nrz.efj.chapter04.item26.unbounded;

import java.util.Set;

public class Numbers {
    static int numElementsInCommon(Set s1, Set s2){
        int res = 0;
        for(Object o1: s1){
            if(s2.contains(o1)){
                res++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(Numbers.numElementsInCommon(Set.of(1,2,3), Set.of(1,2)));
    }

}
