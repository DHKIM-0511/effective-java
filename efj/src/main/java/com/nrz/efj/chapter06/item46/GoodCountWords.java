package com.nrz.efj.chapter06.item46;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Stream;
import static java.util.stream.Collectors.*;
import static java.util.Comparator.*;

/**
 * 같은 일을 하지만 좋은 StreamAPI의 예시이다.
 * forEach 연산은 종단 연산 중 기능이 가장 적고 가장 덜 스트림 답다. 병렬화활 수도 없음.
 * forEach 스트림 계산 결과를 보고할 때만 사용하고, 계산에는 쓰지말자
 * 가끔은 스트림 계산 결과를 기존 컬렉션에 추가하는 증의 다른 용도로 쓸 수 있다.
 * Collectors의 멤버를 정적 임포트하면 가독성이 좋아져 흔히 사용하는 방법임
 * */
public class GoodCountWords {
    static File file = new File("");
    public static void main(String[] args) throws IOException {
        Map<String, Long> freq;
        try (Stream<String> words = new Scanner(file).tokens()){
            freq = words
                .collect(groupingBy(String::toLowerCase, counting()));
        }

        List<String> topTen = freq.keySet().stream()
            .sorted(comparing(freq::get).reversed())
            .limit(10)
            .collect(toList());
    }
}
