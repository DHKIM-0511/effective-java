package com.nrz.efj.chapter01.item03.field;

import java.io.Serializable;

public class Elvis implements IElvis, Serializable {
    /**
     * 싱글톤 오브젝트
     */
    public static final Elvis INSTANCE = new Elvis();
    private static boolean created;

    private Elvis(){
        if(created){
            throw new UnsupportedOperationException("can't be created by constructor");
        }
        created = true;
    }

    @Override
    public void leaveTheBuilding() {
        System.out.println("Whoa baby, I'm outta here!");
    }

    @Override
    public void sing() {
        System.out.println("I'll have a blue~ Christmas without you~");
    }

    //클래스 바깥(다른 클래스)으로 가정
    public static void main(String[] args) {
        Elvis elvis = Elvis.INSTANCE;
        elvis.leaveTheBuilding();
    }

    private Object readResolve() {
        return INSTANCE;
    }
}
