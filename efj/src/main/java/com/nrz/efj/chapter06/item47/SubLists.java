package com.nrz.efj.chapter06.item47;

import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Stream.concat = 반환되는 스트림에 빈리스트 추가
 * flatMap = 모든 프리픽스의 모든 서픽스로 구성된 하나의 스트림을 만든다
 * 프리픽스들과 서픽들의 스트림= IntStream.range, IntStream.rangeClosed가 반환하는 연속 정수값을 매핑해 만듦
 * 즉, 정수 인덱스를 사용한 표준 for문의 스트림 버전이다 {@link  SubListsWithFor}
 * */
public class SubLists {
    public static <E> Stream<List<E>> of(List<E> list){
        return Stream.concat(Stream.of(Collections.emptyList()),
            prefixes(list).flatMap(SubLists::suffixes));
    }

    public static <E> Stream<List<E>> prefixes(List<E> list){
        return IntStream.rangeClosed(1, list.size())
            .mapToObj(end -> list.subList(0,end));
    }

    public static <E> Stream<List<E>> suffixes(List<E> list){
        return IntStream.rangeClosed(0, list.size())
            .mapToObj(start -> list.subList(start,list.size()));
    }
}
