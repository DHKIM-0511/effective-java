package com.nrz.efj.chapter07.item53;

public class VarargsEx {
    static int sum(int... args){
        int sum = 0;
        for(int arg: args) sum += arg;
        return sum;
    }
    static int min(int... args){
        if(args.length == 0) throw new IllegalArgumentException("인수가 1개 이상 필요합니다.");

        int min = args[0];
        for(int i = 1; i < args.length ;i++){
            if(args[i] < min) min = args[i];
        }
        return min;
    }
    //훨씬 더 낫고 명료하다.
    static int min(int firstArg, int... remainingArgs){
        int min = firstArg;
        for(int arg: remainingArgs){
            if(arg < min) min = arg;
        }
        return min;
    }
}
