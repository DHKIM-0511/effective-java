package com.nrz.efj.chapter05.item39;

import java.util.ArrayList;
import java.util.List;

/**
 * m1 = 성공,
 * m2, m3 = 실패
 *
 * */
public class Sample2 {
    @ExceptionTest(ArithmeticException.class)
    public static void m1(){
        int i = 0;
        i = i / i;
    }

    @ExceptionTest(ArithmeticException.class)
    public static void m2(){
        int[] a = new int[0];
        int i = a[1];
    }

    @ExceptionTest(ArithmeticException.class)
    public static void m3(){}

    @ExceptionTest3({IndexOutOfBoundsException.class, NullPointerException.class})
    public static void doublyBad(){
        List<String> list = new ArrayList<>();
        list.addAll(5, null);
    }
}
