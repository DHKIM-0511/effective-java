package com.nrz.efj.chapter03.item18.callback;

public class BobFunctionWrapper implements FunctionToCall{
    private final BobFunction bobFunction;

    public BobFunctionWrapper(BobFunction bobFunction) {
        this.bobFunction = bobFunction;
    }

    @Override
    public void run() {
        this.bobFunction.run();
    }

    @Override
    public void call() {
        this.bobFunction.call();
        System.out.println("커피도 한잔...");
    }
}
