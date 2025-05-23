package com.nrz.efj.chapter03.item20.templatemethod;

public class Client {

    public static void main(String[] args) {
        FileProcessor fileProcessor = new Plus("number.txt");
        System.out.println(fileProcessor.process());

        CallbackFileProcessor callbackFileProcessor = new CallbackFileProcessor("number.txt");
        System.out.println(callbackFileProcessor.process(Integer::sum));

    }
}
