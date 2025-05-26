package com.nrz.efj.chapter04.item26.terms;

import java.util.ArrayList;
import java.util.List;

public class GenericBasic {

    public static void main(String[] args) {
//        List numbers = new ArrayList();
//        numbers.add(10);
//        numbers.add("nrz");
//
//        for(Object num: numbers){
//            System.out.println((Integer) num);
//        }

        //generic 등장 이후
        List<Integer> numbers = new ArrayList<>();
        numbers.add(10);
//        numbers.add("nrz"); compile error

        for(Integer num: numbers){
            System.out.println(num);
        }
    }
}
