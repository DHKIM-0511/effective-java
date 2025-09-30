package com.nrz.efj.chapter06.item42;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * 예전 자바에서 함수 타입을 표현할때,
 * 추상 메서드를 하나만 담은 인터페이스(드물게 추상 클래스)를 사용했다. → 함수 객체 (익명 클래스)
 *
 * Java8부터 생겨난 람다식덕분에 기존에 있던 함수형 인터페이스의 활용성이 높아졌다.
 * {@link LambdaFunction}
 * */
public class AnonymousClass {
    public static void main(String[] args) {
        List<String> words = new ArrayList<>(List.of("APPLE", "XO", "PARI", "ELEMENT","BANANA"));
        Collections.sort(words, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return Integer.compare(o1.length(), o2.length());
            }
        });
        System.out.println(words);
    }
}
