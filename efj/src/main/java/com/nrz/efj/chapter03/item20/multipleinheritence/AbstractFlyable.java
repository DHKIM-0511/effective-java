package com.nrz.efj.chapter03.item20.multipleinheritence;

public class AbstractFlyable implements Flyable{

    @Override
    public void fly() {
        System.out.println("너랑 딱 붙어있을게!");
    }
}
