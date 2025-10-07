package com.nrz.efj.chapter10.item78;

import java.util.concurrent.TimeUnit;

/**
 * 메인 스레드가 1초 후 stopRequest를 true로 설정하면, backgroundThread는 반복문을 빠져나올 것같지만 **영원히 수행됨**
 * 동기화가 문제이다
 * 동기화 하지 않으면 메인 스레드가 수정한 값을 백그라운드 스레드가 언제쯤에나 볼지 알 수 없다
 * OpenJDK 서버 VM이 실제로 적용하는 끌어올리기(hoisting)라는 최적화 기법이다.
 * 이 결과 프로그램은 응답 불가 상태가 되어 더 이상 진전이 없다.
 * stopRequested필드를 동기화해 접근하면 문제 해결 가능 {@link GoodStopThread}
 */
public class StopThread {
    private static boolean stopRequested;

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
