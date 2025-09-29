package com.nrz.efj.chapter05.item39;

import java.lang.annotation.ElementType;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 반복 가능 애너테이션을 여러개 달면, 하나 있을때와 비교하가위해 컨테이너 애너테이션 타입이 적용된다.
 *
 * */

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Repeatable(ExceptionTestContainer.class)
public @interface ExceptionTest3 {
    Class<? extends Throwable>[] value();
}
