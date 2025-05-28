package com.nrz.efj.chapter04.item30._02_after;

import java.util.function.Function;
import java.util.function.UnaryOperator;

public class GenericSingletonFactory {
    private static UnaryOperator<Object> IDENTITY_FN = (t) -> t;

    @SuppressWarnings("unchecked")
    public static <T> UnaryOperator<T> identityFunction(){
        return (UnaryOperator<T>) IDENTITY_FN;
    }

    public static void main(String[] args) {
        String[] strings = {"삼베", "대마", "나일론"};
        Function<String, String> sameString = identityFunction();
        for(String s: strings){
            System.out.println(sameString.apply(s));
        }

        Number[] numbers = {1,2.0,3L};
        Function<Number, Number> sameNumber = identityFunction();
        for(Number n : numbers){
            System.out.println(sameNumber.apply(n));
        }
    }
}
