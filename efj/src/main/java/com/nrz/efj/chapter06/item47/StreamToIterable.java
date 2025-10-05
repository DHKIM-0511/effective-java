package com.nrz.efj.chapter06.item47;

import java.util.stream.Stream;
/**
 * 자바의 타입 추론만으로 형변환 없이 사용할 수 있다.
 * 어떤 Stream API도 Iterable로 반복할 수 있다
 * */
public class StreamToIterable {
    public static <E> Iterable<E> iterableOf(Stream<E> stream){
        return stream::iterator;
    }
}
