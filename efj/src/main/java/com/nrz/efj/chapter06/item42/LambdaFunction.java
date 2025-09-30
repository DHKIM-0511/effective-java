package com.nrz.efj.chapter06.item42;

import java.util.ArrayList;
import java.util.List;

import static java.util.Comparator.*;

/**
 * 컴파일러가 타입 추론할 수 없을때만 타입 명시
 * 타입을 명시하는게 더 명확한 경우를 제외하고 람다식에서 매개변수 타입은 생략한다.
 * 드물게 반환값이나 람다식 전체를 캐스팅할 수 도 있다.
 *
 * 람다는 함수형 인터페이스에서만 쓰인다.
 * 추상클래스의 인스턴스를 만들때, 람다를 쓸 수 없고 익명클래스를 사용한다.
 * 람다는 자신을 참조할 수 없다. 즉, 람다에서 this는 바깥 인스턴스이다.
 * 람다를 직렬화하는것은 극히 삼가하자 (JVM별로 다를 수 있다)
 * 직렬화 해야만 하는 함수 객체는 private static 중첩 클래스의 인스턴스를 사용하자.
 * */
public class LambdaFunction {
    public static void main(String[] args) {
        /*
         * 정렬 함수
         * 람다식 반환 => Comparator<String>
         * 매개변수(,s1,s2) 반환 => String
         * */
        List<String> words = new ArrayList<>(List.of("APPLE", "XO", "PARI", "ELEMENT","BANANA"));

//        Collections.sort(words, (s1,s2) -> Integer.compare(s1.length(), s2.length()));
//        Collections.sort(words, comparingInt(String::length));
        words.sort(comparingInt(String::length));
        System.out.println(words);
    }
}
