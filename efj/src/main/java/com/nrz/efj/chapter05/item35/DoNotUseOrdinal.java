package com.nrz.efj.chapter05.item35;
/**
 *  유지보수가 끔찍하다
 *  1. 상수 선언이 바뀌거나 새로운 상수  추가시 바로 깨짐
 *  2. 8중주, 복4중주 모두 8명이므로 이러한거 표현 불가
 *  3. 값을 비워 둘 수 없어서 11명에대한 연주 이름이 없으므로 더미 상수를 써야 함
 *
 *  따라서 인스턴스 필드에 저장하는게 좋다 {@link Ensemble} 클래스를 참고.
 *  ordinal은 대부분 쓸일이  없고, EnumMap, EnumSet같은  이늄기반 자료구조에 쓸 목적으로 설계함
 * */
public enum DoNotUseOrdinal {
    SOLO, DUET, TRIO, QUARTET, QUINTET,
    SEXTET, SEPTET, OCTET, NONET, DECTET;

    public int numberOfMusicians(){return  ordinal() + 1;}
}
