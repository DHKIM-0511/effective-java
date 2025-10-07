package com.nrz.efj.chapter10.item79;

import java.util.HashSet;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class ObservableSetTest {
    public static void main(String[] args) {
        test1();
//        test2();
    }
    /**
     * 23까지 출력후 조용히 종료될것을 예상
     * -> ConcurrentModificationException 을 던진다.
     * -> added 가 호출된 시점이 notifyElementAdded가 관찰자들의 리스트를 순회하는 도중이기 때문이다.
     * added -> ObservableSet의 removeObserver를 호출 -> observers.remove 호출
     * 따라서 리스트에서 원소를 제거하고자하지만, 이는 리스트 순회중 허용되지 않는다.
     *
     * notifyElementAdded() 에서 동기화 블럭안에서 동시 수정을 막지는 못하지만
     * 콜백을 거쳐 되돌아와 수정하는 것 까지 막지는 못한다.
     */
    private static void test1() {
        ObservableSet<Integer> set = new ObservableSet<>(new HashSet<>());
        set.addObserver(new SetObserver<>() {
            @Override
            public void added(ObservableSet<Integer> s, Integer e) {
                System.out.println(e);
                if(e == 23) s.removeObserver(this);
            }
        });

        for(int i = 0; i < 100 ; i++) set.add(i);
    }

    /**
     * 구독 해지를 하는 경우에 다른 실행자 서비스를 사용해 다른 서비스에 위임한다.
     * 예외는 발생하지 않지만, 교착상태에 빠진다.
     *
     * 백그라운드 스레드가 s.removeObserver 를 호출하면 관찰자를 잠그려함 -> 락을 얻을 수 없다.
     * 메인 스레드가 락을 가지고 있음. 그와 동시에 메인 스레드는 백그라운드 스레드가 관찰자를 제거하기를 기다린다.
     */
    private static void test2() {
        ObservableSet<Integer> set = new ObservableSet<>(new HashSet<>());
        set.addObserver(new SetObserver<>() {
            @Override
            public void added(ObservableSet<Integer> s, Integer e) {
                System.out.println(e);
                if(e == 23){
                    ExecutorService exec = Executors.newSingleThreadExecutor();

                    try{
                        exec.submit(() -> s.removeObserver(this)).get();
                    }catch (ExecutionException | InterruptedException ex){
                        throw new AssertionError(ex);
                    }finally {
                        exec.shutdown();
                    }
                }
            }
        });

        for(int i = 0; i < 100 ; i++) set.add(i);
    }
}
