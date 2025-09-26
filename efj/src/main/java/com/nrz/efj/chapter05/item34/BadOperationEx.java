package com.nrz.efj.chapter05.item34;

/**
 * 안 예쁘다
 * AssertionError는 실제로 도달하지 않겠지만, 기술적으로 도달 할 수 있으므로 컴파일 예외 안던지면 컴파일 에러 발생
 * 깨지기 쉬운 코드이다 -> 새로운 연산 추가 시 switch문 추가 필요
 * */
public enum BadOperationEx {
    PLUS, MINUS, TIMES, DIVIDE;

    public double apply(double x, double y){
        switch (this){
            case PLUS: return x+y;
            case MINUS: return x-y;
            case TIMES: return x*y;
            case DIVIDE: return x/y;
        }
        throw new AssertionError("알 수 없는 연산: " + this);
    }
}
