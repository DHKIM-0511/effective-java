package com.nrz.efj.chapter03.item22.constantinterface;

public class MyClass implements PhysicalConstants{

    public static void main(String[] args) {
        //인터페이스의 상수는 바로 조회 가능
        //하지만 상수를 사용하는 용도로만 인터페이스를 적용하는건 지양
        System.out.println(BOLTZMANN_CONSTANT);
    }
}
