package com.nrz.efj.chapter06.item47;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class SubListsWithFor {
    static List<Character> src = new ArrayList<>();
    public static void main(String[] args) {

        for(int start = 0; start < src.size(); start++){
            for(int end = start+1 ; end <= src.size(); end++){
            System.out.println(src.subList(start, end));
            }
        }
    }

    /**
     * 위는 아래처럼 스트림으로 만들 수 있지만, 보기 안좋음
     * */
    public static <E>Stream<List<E>> of(List<E> list){
        return IntStream.range(0, list.size())
            .mapToObj(start ->
                IntStream.rangeClosed(start + 1, list.size())
                    .mapToObj(end -> list.subList(start, end)))
            .flatMap(x -> x);
    }
}
