package com.nrz.efj.chapter06.item42;

import java.util.function.DoubleBinaryOperator;


/**
 * 람다로 간편하게 "상수별 클래스 바디" 기법을 대체했다.
 * 하지만 람다는 이름이 없고, 문서화 할 수 없다. 따라서 코드 자체로 명확하지 않거나
 * 코드 줄 수가 길어지면 람다를 지양해야한다. (람다는 세 줄 안에 끝나는게 좋다)
 * */
public enum Operation {
    PLUS("+",(x, y) -> x + y),
    MINUS("-",(x, y) -> x - y),
    TIMES("*",(x, y) -> x * y),
    DIVIDE("/",(x, y) -> x / y);

    private final String symbol;
    private final DoubleBinaryOperator op;

    Operation(String symbol, DoubleBinaryOperator op){
        this.symbol = symbol;
        this.op = op;
    }

    @Override public String toString(){return symbol;}
    public double apply(double x, double y){
        return op.applyAsDouble(x, y);
    }
}
