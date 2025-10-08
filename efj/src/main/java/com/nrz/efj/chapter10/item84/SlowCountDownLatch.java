package com.nrz.efj.chapter10.item84;

/**
 * 피해야할 극단적인 예시.
 */
public class SlowCountDownLatch {
    private int count;

    public SlowCountDownLatch(int count){
        if(count < 0) throw new IllegalArgumentException(count + "< 0");
        this.count = count;
    }

    public void await(){
        while (true){
            //busy waiting 상태를 지속함 -> CPU 점유
            synchronized (this){
                if(count == 0) return;
            }
        }
    }

    public synchronized void countDown(){
        if(count != 0) count--;
    }
}
