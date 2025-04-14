package com.nrz.efj.chapter01.item01;

import com.nrz.chinese_hello.ChineseHelloService;
import com.nrz.hello.HelloService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean
    public HelloService helloService(){
        return new ChineseHelloService();
    }

}
