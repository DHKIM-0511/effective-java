package com.nrz.efj.chapter10.item78;

import java.util.concurrent.TimeUnit;

/**
 * volatile 한정자는 배타적 수행과는 상관 없지만 항상 가장 최근에 기록된 값을 읽게 됨을 보장한다.
 * volatile 은 주의해서 사용해야한다{@link BadVolatileEx}
 */
public class GooodStopThread {
    private static volatile boolean stopRequested;
    public static void main(String[] args) throws InterruptedException{
        Thread backgroundThread = new Thread(() -> {
            int i = 0;
            while (!stopRequested) i++;
        });
        backgroundThread.start();

        TimeUnit.SECONDS.sleep(1);
        stopRequested = true;
    }
}
