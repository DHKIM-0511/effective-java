package com.nrz.efj.chapter06.item45;

import java.math.BigInteger;
import java.util.stream.Stream;
import static java.math.BigInteger.*;

/**
 * 소수들을 사용해 메르센 수를 계산하고 결과값이 소수인 경우만 남긴다
 * 매직넘버 50 은 소쉉 검사가 true를 반환할 확률을 제어한다
 * 결과 스트림의 원소 수를 20개로 제한하고 작업이 끝나면 결과를 출력한다
 * */
public class MersennePrime {
    static Stream<BigInteger> primes(){
        return Stream.iterate(TWO, BigInteger::nextProbablePrime);
    }

    public static void main(String[] args) {
        primes().map(p -> TWO.pow(p.intValueExact()).subtract(ONE))
            .filter(mersenne -> mersenne.isProbablePrime(50))
            .limit(20)
            .forEach(System.out::println);
    }
}
