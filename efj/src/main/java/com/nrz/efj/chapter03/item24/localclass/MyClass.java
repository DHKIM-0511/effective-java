package com.nrz.efj.chapter03.item24.localclass;

public class MyClass {
    private int number = 10;

    void doSomething(){
        class LocalClass{
            private void printNumber(){
                System.out.println(number);
            }
        }

        LocalClass localClass = new LocalClass();
        localClass.printNumber();
    }

    public static void main(String[] args) {
        MyClass aClass = new MyClass();
        aClass.doSomething();
    }
}
