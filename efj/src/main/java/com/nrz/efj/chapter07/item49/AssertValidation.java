package com.nrz.efj.chapter07.item49;

/**
 * 이 단언문들은 자신이 단언한 조건이 무조건 참이라고 선언한다.
 * 다른 유효성 검사와 몇가지 면에서 다르다
 * 1. 실패하면 AssertionError
 * 2. 런타임에 아무런 효과도 성능 저하도 없다 (실행 명령에 -ea or --enableassertions 플래그 추가시 런타임 영향을 준다)
 * */
public class AssertValidation {
    private static void sort(long[] a, int offset, int length){
        assert a != null;
        assert offset >= 0 && offset <= a.length;
        assert length >= 0 && length <= a.length - offset;

        // 계산 수행
    }
}
