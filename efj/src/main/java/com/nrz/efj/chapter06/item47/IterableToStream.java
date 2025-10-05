package com.nrz.efj.chapter06.item47;

import java.util.stream.Stream;
import java.util.stream.StreamSupport;
/**
 * 객체 시퀀스를 반환하는 메서드를 작성하는데,
 * 이메서드가 오직 스트림 파이프라인만 쓰일 걸 안다면 Iterable만 반환하자
 *
 * 하지만 공개 API를 작성할 때는 스트림 파이프라인을 사용하는 사람과 반복문에서 쓰려는 사람 모두를 배려해야한다.
 * (사용자 대부분이 한 방식만 사용할 거라는 마땅한 근거가 없다면)
 * */
public class IterableToStream {
    public static <E> Stream<E> streamOf(Iterable<E> iterable){
        return StreamSupport.stream(iterable.spliterator(), false);
    }
}
