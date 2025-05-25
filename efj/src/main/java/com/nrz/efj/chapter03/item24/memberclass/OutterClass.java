package com.nrz.efj.chapter03.item24.memberclass;

public class OutterClass {
    private int number = 10;

    // 멤버 클래스는 outterClass의 인스턴스에대한 참조가 생기므로 해당 클래스를 먼저 만들어 사용해야함
    // 외부 클래스 정보가 필요없다면 불필요하므로 이럴땐 정적으로 사용
    private class InnerClass{
        void doSomething(){
            System.out.println(number);
        }
    }

    public static void main(String[] args) {
        InnerClass aClass = new OutterClass().new InnerClass();
        aClass.doSomething();
    }
}
