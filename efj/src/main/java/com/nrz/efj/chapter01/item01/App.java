package com.nrz.efj.chapter01.item01;

import com.nrz.hello.HelloService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {

    /*
    * HelloService = 서비스 제공자 인터페이스
    * AppConfig = 서비스 제공자 등록 API
    * applicationContext.getBean(HelloService.class); = 서비스 접근 API
    * */
    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        HelloService service = applicationContext.getBean(HelloService.class);
        System.out.println(service.hello());
    }
}
