package com.nrz.efj.chapter01.item08.finalizer;

public class FinalizerIsBad {

    @Override
    protected void finalize() throws Throwable {
        System.out.print("");
    }
}
