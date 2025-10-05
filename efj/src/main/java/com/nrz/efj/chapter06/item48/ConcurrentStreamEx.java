package com.nrz.efj.chapter06.item48;

import java.math.BigInteger;
import java.util.stream.LongStream;

/**
 * n보다 작거나 같은 소수의 개수를 계산
 * 병렬화로 3 ~ 4배의 수행 속도 이득을 볼 수 있지만, n이 크다면 이방식으로 계산하는건 좋지않다.
 * "레머의 공식" 이라는 효율적인 알고리즘이 있기 때문이다.
 * */
public class ConcurrentStreamEx {
    static long pi(long n){
        return LongStream.rangeClosed(2, n)
            .mapToObj(BigInteger::valueOf)
            .filter(i -> i.isProbablePrime(50))
            .count();
    }

    static long goodPi(long n){
        return LongStream.rangeClosed(2, n)
            .parallel()
            .mapToObj(BigInteger::valueOf)
            .filter(i -> i.isProbablePrime(50))
            .count();
    }
}
