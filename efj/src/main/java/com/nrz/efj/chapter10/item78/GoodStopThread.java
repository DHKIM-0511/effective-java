package com.nrz.efj.chapter10.item78;

import java.util.concurrent.TimeUnit;

/**
 * 쓰기와 읽기 메서드를 모두 동기화 해야한다.
 * 동기화 = 배타적 수행, 스레드 간 통신에 목적이있다. (이 코드에서는 통신 목적)
 * 더 빠른 대안이있다. {@link GooodStopThread}
 */
public class GoodStopThread {
    private static boolean stopRequested;
    private static synchronized void requestStop(){
        stopRequested = true;
    }
    private static synchronized boolean stopRequested(){
        return stopRequested;
    }
    public static void main(String[] args) throws InterruptedException{
        Thread backgroundThread = new Thread(() -> {
            int i = 0;
            while (!stopRequested()) i++;
        });
        backgroundThread.start();

        TimeUnit.SECONDS.sleep(1);
        requestStop();
    }
}
