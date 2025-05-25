package com.nrz.efj.chapter03.item24.staticmemberclass;

public class OutterClass {
    private static int number = 10;

    // 정적 멤버 클래스
    static private class InnerClass{
        void doSomething(){
            System.out.println(number);
        }
    }

    public static void main(String[] args) {
        InnerClass aClass = new InnerClass();
        aClass.doSomething();
    }
}
