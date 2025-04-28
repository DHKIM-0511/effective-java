package com.nrz.efj.chapter01.item07.reference;

import java.lang.ref.SoftReference;

public class SoftReferenceExample {
    public static void main(String[] args) throws InterruptedException {
        Object strong = new Object();
        SoftReference<Object> soft = new SoftReference<>(strong);
        strong = null;

        System.gc();
        Thread.sleep(3000L);

        // 거의 안 없어짐 메모리가 충분해서
        System.out.println(soft.get());
    }
}
