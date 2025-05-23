package com.nrz.efj.chapter03.item20.skeleton;

import java.util.AbstractList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class IntArrays {
    static List<Integer> intArrayAsList(int[] a){
        Objects.requireNonNull(a);

        return new AbstractList<>(){
            @Override public Integer get(int i){return a[i];}
            @Override public Integer set(int i, Integer val){
                int oldVal = a[i];
                a[i] = val;
                return oldVal;
            }
            @Override public int size() {return a.length;}
        };
    }

    public static void main(String[] args) {
        int[] a = new int[10];
        for(int i = 0 ; i < a.length; i++) a[i] = i;

        List<Integer> list = intArrayAsList(a);
        Collections.shuffle(list);
        System.out.println(list);
    }
}
