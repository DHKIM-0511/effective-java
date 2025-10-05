package com.nrz.efj.chapter06.item46;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Stream;

/**
 * 동작과 결과는 올바르지만 절대 스트림 코드가 아니다.
 * 스트림 코드를 가장한 반복 코드임. 스트림 코드의 이점을 못살려, 더 길고, 유지보수에 좋지 않다
 *
 * 이유
 * 모든 연산이 forEach에서 발생 -> 외부 상태를 수정하는 람다를 실행하면서 문제 발생
 * forEach에서 Stream에서 수행한 연산 결과를 보여주는 일 이상을 함 (여기선 람다가 상태를 수정함)
 * {@link GoodCountWords}
 * */
public class CountWords {
    static File file = new File("");
    public static void main(String[] args) throws IOException {
        Map<String, Long> freq = new HashMap<>();
        try(Stream<String> words = new Scanner(file).tokens()){
            words.forEach(w -> {
                freq.merge(w.toLowerCase(), 1L, Long::sum);
            });
        }
    }
}
