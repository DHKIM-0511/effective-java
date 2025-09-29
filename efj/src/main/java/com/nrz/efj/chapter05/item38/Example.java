package com.nrz.efj.chapter05.item38;

import java.util.Arrays;
import java.util.Collection;

public class Example {
    public static void main(String[] args) {
        double x = 3.0;
        double y = 4.0;

        test(ExtendedOperation.class, x, y);
        test(Arrays.asList(ExtendedOperation.values()), x, y);
    }
    /**
     * Class객체를 넘기는 방법
     * test에 ExtendedOperation의 class 리터럴을 넘겨 확장된 연산이 무엇인지 알려준다.
     * class리터럴 = 한정적 타입 토큰 역할
     * <T extends Enum<T> & Operation> Class<T> => Class객체가 이늄 && Operation 하위 타입이어야함
     * */
    private static <T extends Enum<T> & Operation> void test(
        Class<T> opEnumType, double x, double y) {

        for (Operation op : opEnumType.getEnumConstants()) {
            System.out.printf("%f %s %f = %f%n",
                x, op, y, op.apply(x,y));
        }
    }
    /**
     * Collection<? extends Operation> 을 넘기는 방법
     * 위 보다 덜 복잡, 더 유연함
     * 여러 구현 타입의 연산을 조합할 수 있다
     * */
    private static void test(Collection<? extends Operation> opSet,
        double x, double y){
        for(Operation op: opSet){
            System.out.printf("%f %s %f = %f%n",
                x,op,y,op.apply(x,y));
        }
    }
}
