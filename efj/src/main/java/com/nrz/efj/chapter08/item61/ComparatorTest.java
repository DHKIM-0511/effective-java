package com.nrz.efj.chapter08.item61;

import java.util.Comparator;

/**
 * 박싱된 타입의 경우 같은 값을 비교하는데 1을 출력한다.
 * 박싱된 타입에 " == "연산을 수행하면 참조 식별성을 기준으로 비교하여 오류가 발생한다.
 */
public class ComparatorTest {
    public static void main(String[] args) {
        Comparator<Integer> naturalOrder = (i,j) -> (i < j)? -1 : (i == j ? 0 : 1);
        Comparator<Integer> goodNaturalOrder = (iBoxed, jBoxed) -> {
            int i = iBoxed, j = jBoxed;
            return i < j ? -1 : (i == j ? 0: 1);
        };

        System.out.println(naturalOrder.compare(new Integer(42), new Integer(42)));
        System.out.println(goodNaturalOrder.compare(new Integer(42), new Integer(42)));
    }
}
