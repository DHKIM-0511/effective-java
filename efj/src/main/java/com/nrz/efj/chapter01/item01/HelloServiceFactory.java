package com.nrz.efj.chapter01.item01;

import com.nrz.chinese_hello.ChineseHelloService;
import com.nrz.hello.HelloService;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Optional;
import java.util.ServiceLoader;

public class HelloServiceFactory {

    public static void main(String[] args)
        throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        //구현체에 의존 하지 않음
        ServiceLoader<HelloService> loader = ServiceLoader.load(HelloService.class);
        Optional<HelloService> first = loader.findFirst();
        first.ifPresent(h -> System.out.println(h.hello()));


        //구현체에 의존적
        HelloService service = new ChineseHelloService();
        System.out.println(service.hello());

        //리플렉션
        Class<?> aClass = Class.forName("com.nrz.chinese_hello.ChineseHelloService");
        Constructor<?> constructor = aClass.getConstructor();
        HelloService helloService = (HelloService) constructor.newInstance();
        System.out.println(helloService.hello());
    }
}
