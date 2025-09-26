package com.nrz.efj.chapter05.item34;
/**
*정수 열거 패턴
*1. 타입 안전성 없음
*2. 표현력 안좋음 (잘못된 정수를 보내도 경고 출력 x)
*3. 값이 바뀌면 클라이언트도 엉뚱하게 동작
*4. 문자열로 변환 까다로움
*/
public class BadEnum {
    public static final int APPLE_HUJI = 0;
    public static final int APPLE_PIPPIN = 1;
    public static final int APPLE_GRANNY_SMITH = 2;

    public static final int ORANGE_NAVEL = 0;
    public static final int ORANGE_TEMPLE = 1;
    public static final int ORANGE_BLOOD = 2;
}
