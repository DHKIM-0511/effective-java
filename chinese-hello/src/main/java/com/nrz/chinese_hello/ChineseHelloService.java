package com.nrz.chinese_hello;

import com.nrz.hello.HelloService;

public class ChineseHelloService implements HelloService {

    @Override
    public String hello() {
        return "Ni hao";
    }
}
