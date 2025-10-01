package com.nrz.efj.chapter06.item45;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;

/**
 * Stream, 메소드 참조 등을 사용하여 짧게 사용했지만
 * 가독성과 유지보수가 매우어려워져 좋지않다.
 *
 * 절충하여 사용하자{@link GoodAnagrams}
 * */
public class BadAnagrams {
    public static void main(String[] args) throws IOException {
        Path dictionary = Paths.get(args[0]);
        int minGroupSize = Integer.parseInt(args[1]);

        try(Stream<String> words = Files.lines(dictionary)){
            words.collect(
                groupingBy(word -> word.chars().sorted()
                    .collect(StringBuilder::new,
                        (sb,c) -> sb.append((char)c),
                        StringBuilder::append).toString()))
                .values().stream()
                .filter(group -> group.size() >= minGroupSize)
                .map(group -> group.size() + ": " + group)
                .forEach(System.out::println);
        }
    }
}
