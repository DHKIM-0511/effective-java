package com.nrz.efj.chapter04.item32.random;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class RandomExample {

    public static void main(String[] args) {
        Random random = new Random();
        System.out.println(random.nextInt(10));

        System.out.println(ThreadLocalRandom.current().nextInt(10));
    }

    private int value;

    public synchronized  int compareAndSwap(int expectedValue, int newValue){
        int readValue = value;
        if(readValue == expectedValue) value = newValue;
        return readValue;
    }
}
