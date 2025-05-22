package com.nrz.efj.chapter03.item18.callback;

public class BobFunction implements FunctionToCall{

    private final Service service;

    public BobFunction(Service service) {
        this.service = service;
    }


    @Override
    public void call() {
        System.out.println("밥을 먹을까...");
    }

    @Override
    public void run() {
        this.service.run(this); // self -> Wrapper 클래스가와도 자기 자신이 인수로감
    }
}
