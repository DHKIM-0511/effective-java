package com.nrz.efj.chapter01.item01;

import com.nrz.chinese_hello.ChineseHelloService;
import com.nrz.hello.HelloService;
import java.util.Optional;
import java.util.ServiceLoader;

public class HelloServiceFactory {

    public static void main(String[] args) {
        //구현체에 의존 하지 않음
        ServiceLoader<HelloService> loader = ServiceLoader.load(HelloService.class);
        Optional<HelloService> first = loader.findFirst();
        first.ifPresent(h -> System.out.println(h.hello()));


        //구현체에 의존적
        HelloService service = new ChineseHelloService();
        System.out.println(service.hello());

    }
}
