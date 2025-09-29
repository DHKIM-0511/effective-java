package com.nrz.efj.chapter05.item39;

/**
 * m1 = 성공,
 * m3, m7 = 실패
 * m5 = 잘못 사용
 * 나머지 = 무시
 *
 * @Test 에너테이션이 Sample 클래스에 의미를 부여하지 않는다.
 * 단지, 애너테이션에 관심있는 도구에서 특별한 처리를 할 수 있게 한다.
 * */
public class Sample {
    @Test public static void m1(){} // 성공
    public static void m2(){}
    @Test public static void m3(){
        throw new RuntimeException("실패"); // 실패
    }
    public static void m4(){}
    @Test public void m5(){} // 정적 메서드가 아님
    public static void m6(){}
    @Test public static void m7(){
        throw new RuntimeException("실패"); // 실패
    }
    public static void m8(){}
}
