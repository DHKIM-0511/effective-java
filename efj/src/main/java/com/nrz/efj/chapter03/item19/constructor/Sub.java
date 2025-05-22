package com.nrz.efj.chapter03.item19.constructor;

import java.time.Instant;

public final class Sub extends Super{
    private final Instant instant;

    Sub(){
        //super() 과정에서 오버라이드된 overrideMe가 호출된
        instant = Instant.now();
    }

    @Override public void overrideMe(){
        System.out.println(instant);
    }

    public static void main(String[] args) {
        Sub sub = new Sub();
        sub.overrideMe();
    }
}
