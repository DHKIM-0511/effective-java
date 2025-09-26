package com.nrz.efj.chapter05.item34;
/**
*이늄 = 클래스
*상수하나당 인스턴스를 만들어 public static final 필드로 공개
*밖에서 접근 할 수 있는 생성자 없음 = final = 하나만 존재
*
* 장점
*1. 컴파일 타임 타입 안전성 제공
*2. 각 NameSpace 덕분에 이름이 같은 상수도 공존
*3. toString()으로 문자열 활용 가능
*4. 이늄 내부 메서드 구현 가능
*5. 인터페이스나 구현 가능
*/
public class EnumEx {
    enum APPLE{FYJI, PIPPM, GRANNY_SMITH}
    enum ORANGE{NAVEL, TEMPLE, BLOOD}
}
