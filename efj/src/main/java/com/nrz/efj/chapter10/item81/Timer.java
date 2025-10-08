package com.nrz.efj.chapter10.item81;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * ready 래치는 작업자 스레드들이 준비가 완료됐음을 스레드에 통지한다.
 * 통지를 끝낸 작업자 스레드들은 start 래치가 열리기 기다린다.
 * 마지막 작업자 스레드가 ready.countDown 을 호출하면 타이머 스레드가 시작 시각을 기록하고 start.countDown 을 호출하여 작업자를 깨운다.
 * 직후, 타이머 스레드는 세 번째 래치인 done 래치가 열리기를 기다린다.
 * done 래치는 마지막 남은 작업자 스레드가 동작을 마치고 done.countDown 을 호출하면 열린다.
 * 타이머 스레드는 done 래치가 열리지마자 꺠어나 종료 시각을 기록한다.
 *
 * time()의 매개변수 executor 는 concurrency 매개변수로 지정한 수 만큼 스레드를 생성할 수 있어야한다.
 * 아니면 무한 대기 -> 기아 교착상태가 유지된다.
 * InterruptedException 을 캐치한 작업자 스레드는 Thread.currentThread().interrupt()를 사용해 인터럽트를 되살리고 run()에서 빠져나온다
 *
 * 시간 간격을 잴 때는 항상 System.nanoTime() 을 사용하자(currentTimeMills 사용 x)
 *
 * 작업에 충분한 시간(1초 이상) 걸리지 않는다면 정확한 시간 측정이 어렵다.
 * -> 정밀한 시간 측정은 매우 어려움 -> jmh 같은 특수 프레임워크 고려하자
 */
public class Timer {
    public static long time (Executor executor, int concurrency, Runnable action) throws InterruptedException{
        CountDownLatch ready = new CountDownLatch(concurrency);
        CountDownLatch start = new CountDownLatch(1);
        CountDownLatch done = new CountDownLatch(concurrency);

        for(int i = 0 ; i < concurrency ; i++){
            executor.execute(() -> {
                //타이머에게 준비를 마쳤음을 알린다.
                ready.countDown();
                try {
                    //모든 작업자 스레드가 준비될 때까지 기다린다.
                    start.await();
                    action.run();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                } finally {
                    //타이머에게 작업을 마쳤음을 알린다.
                    done.countDown();
                }
            });
        }
        ready.await();// 모든 작업자가 준비될 때까지 기다린다.
        long startNanos = System.nanoTime();
        start.countDown(); // 작업자들을 깨운다.
        done.await(); //모든 작업자가 일을 끝마치기를 기다린다.
        return System.nanoTime() - startNanos;
    }
}
