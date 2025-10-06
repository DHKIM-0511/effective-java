package com.nrz.efj.chapter07.item52;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 오버로딩된 메서드의 경우, 컴파일 타임에 해당 타입을 기반으로 메서드 호출이 정해진다.
 * 따라서 for 문의 c의 타입은 Collection<?> 타입이어서 "그 외" 만 세번 호출된다.
 *
 * 문제 해결 방법 {@link GoodCollectionClassifier}
 * */
public class CollectionClassifier {
    public static String classify(Set<?> s){
        return "집합";
    }
    public static String classify(List<?> lst){
        return "리스트";
    }
    public static String classify(Collection<?> c){
        return "그 외";
    }

    public static void main(String[] args) {
        Collection<?>[] collections = {
            new HashSet<String>(),
            new ArrayList<BigInteger>(),
            new HashMap<String, String>().values()
        };

        for (Collection<?> c : collections) {
            System.out.println(classify(c));
        }
    }
}
