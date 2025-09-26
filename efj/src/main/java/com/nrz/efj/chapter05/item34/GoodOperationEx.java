package com.nrz.efj.chapter05.item34;

import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.springframework.expression.Operation;

/**
 * 상수 별 클래스 몸체 구현 가능
 * apply 추상 메서드 덕분에 재정의 안하면 알려줌
 * 열거타입의 정적 필드 중 열거타입의 생성자에서 접근할 수 있는것 = 상수 변수(static final)
 * 단점
 * 열거 타입 상수간 코드 공유가 어려움
 * */
public enum GoodOperationEx {
    PLUS("+"){public double apply(double x, double y){return x+y;}},
    MINUS("-"){public double apply(double x, double y){return x-y;}},
    TIMES("*"){public double apply(double x, double y){return x*y;}},
    DIVIDE("/"){public double apply(double x, double y){return x/y;}};

    //이늄이 상수 생성 후 static 필드 초기화시 Map 추가
    private static final Map<String, GoodOperationEx> stringToEnum = Stream.of(values()).collect(Collectors.toMap(Object::toString, e -> e));

    private final String symbol;
    GoodOperationEx(String symbol){this.symbol = symbol;}
    @Override public String toString(){return symbol;}

    public static Optional<GoodOperationEx> fromString(String symbol){
        return Optional.ofNullable(stringToEnum.get(symbol));
    }

    public abstract double apply(double x, double y);

    /**
     * 일반적으로 switch문은 이늄과 안어울리지만
     * 기존에 있던 이늄에 상수 별 동작을 혼합할때는 효과가 좋다
     * */
    public static GoodOperationEx inverse(GoodOperationEx op){
        switch (op){
            case PLUS: return GoodOperationEx.MINUS;
            case MINUS: return GoodOperationEx.PLUS;
            case TIMES: return GoodOperationEx.DIVIDE;
            case DIVIDE: return GoodOperationEx.TIMES;

            default: throw  new AssertionError("알 수 없는 연산: " + op);
        }
    }

    public static void main(String[] args) {
        double x = Double.parseDouble("2");
        double y = Double.parseDouble("4");

        for(GoodOperationEx op : GoodOperationEx.values()){
            System.out.printf("%f %s %f = %f%n",
                x, op, y, op.apply(x,y));
        }
    }
}
