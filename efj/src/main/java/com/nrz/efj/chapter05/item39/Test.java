package com.nrz.efj.chapter05.item39;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 테스트 메서드임을 선언하는 애너테이션
 * 매개변수 없는 정적 메서드 전용
 *
 * 아래와 같은 제약조건을 컴파일러가 강제하려면 애노테이션 처리기를 직접 구현해야한다(javas.annotation.processing API 문서 참고)
 *
 * 매개 변수 없이 단순한 대상에 마킹한다 -> 마커 에노테이션
 * */

//메타애너테이션
@Retention(RetentionPolicy.RUNTIME) // 테스트가 runtime에도 유지되어야한다
@Target(ElementType.METHOD) //메서드 레벨에서 선언되어야함
public @interface Test {

}
