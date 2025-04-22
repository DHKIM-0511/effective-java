package com.nrz.efj.chapter01.item04;

import org.springframework.context.annotation.AnnotationConfigUtils;
import org.springframework.util.StringUtils;

public class UtilityClass extends StringUtils {
    /**
     * 이 클래스는 인스턴스를 만들 수 없습니다.
     */
    private UtilityClass() {
        throw new AssertionError();
    }

    public static String hello() {
        return "hello";
    }

    public static void main(String[] args) {
        String hello = UtilityClass.hello();

        UtilityClass utilityClass = new UtilityClass();
        utilityClass.hello();


    }
}
