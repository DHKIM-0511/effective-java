package com.nrz.efj.chapter10.item78;

import java.util.concurrent.atomic.AtomicLong;

/**
 * 이 패키지는 락 없이도 Thread-safe한 프로그래밍을 지원하는 클래스가 있다.
 * volatile은 동기화의 목적 중, 스레드간 통신만 만족하지만 이 패키지는 둘 다 만족한다.
 */
public class AtomicLongEx {
    private static final AtomicLong nextSerialNumber = new AtomicLong();
    public static long genSerialNumber(){
        return nextSerialNumber.getAndIncrement();
    }
}
