package com.nrz.efj.chapter10.item78;

/**
 * 이 메서드는 매번 고유한 값을 반환할 의도로 만들어졌다.(2^32 를 넘어가지 않는다면)
 * nextSerialNumber 에 원자적 접근이 가능하고, 어떤 값이든 허용한다. 따라서 동기화 없이 불변식을 보호할 수 있어보인다.
 * 하지만 동기화가 필요하다
 *
 * -> "++" 연산내에서 nextSerialNumber 필드에 두번 접근하기 때문이다. (값 읽기, 새로운 값 저장)
 * 만약 두번째 스레드가 두 동작 사이에 값을 읽어가면 첫 번째 스레드와 같은 값을 돌려받는다.
 * -> 안전 실패
 *
 * genSerialNumber()에 synchronized 한정자를 붙이면 해결된다.
 * synchronized 를 붙였다면 volatile 은 제거해야한다.
 *
 * 더 견고 하게 하고자한다면, long 을 사용하거나 genSerialNumber 가 최대값에 도달하면 예외를 던지게하자.
 * AtomicLong으로 쉽게 문제를 해결할 수 있다. {@link AtomicLongEx}
 */
public class BadVolatileEx {
    private static volatile int nextSerialNumber = 0;
    public static int genSerialNumber(){
        return nextSerialNumber++;
    }
}
