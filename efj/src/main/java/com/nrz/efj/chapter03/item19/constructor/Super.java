package com.nrz.efj.chapter03.item19.constructor;

public class Super {

    //생성자가 override 가능한 메서드를 직,간접적으로 호출하면 안된다
    public Super(){
        overrideMe();
    }

    public void overrideMe(){

    }
}
