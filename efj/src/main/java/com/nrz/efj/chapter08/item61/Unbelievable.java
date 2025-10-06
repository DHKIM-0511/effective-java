package com.nrz.efj.chapter08.item61;

/**
 * i == 42 검사시 NPE 가 발생한다.
 * 기본 타입과 박싱된 기본타입을 혼용하는 연산에서는 박싱된 기본타입의 박싱이 자동으로 풀린다
 * null 참조를 언박싱하면 자동 NPE 발생
 */
public class Unbelievable {
    static Integer i;
    public static void main(String[] args) {
        if (i == 43) {
            System.out.println("믿을 수 없군");
        }
    }
}
