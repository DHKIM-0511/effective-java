package com.nrz.efj.chapter07.item50;

import java.util.Date;

/**
 * 완벽한 불변이다.
 * (네이티브 메서드나 리플렉션 같이 언어외 적인 수단을 동원하지 않고는 불가능)
 * 생성자와는 달리 접근자 메서드에선 clone을 써도 된다.(Date가 확실 , 신뢰 할 수 없는 하위 클래스가 아님)
 * */
public class GooodPeriod {
    private final Date start;
    private final Date end;

    public GooodPeriod(Date start, Date end){
        this.start = new Date(start.getTime());
        this.end = new Date(end.getTime());

        if(start.compareTo(end) > 0)
            throw new IllegalArgumentException(start + "가" + end + "보다 늦다.");
    }
    public Date start(){
        return new Date(start.getTime());
    }
    public Date end(){
        return new Date(end.getTime());
    }
}
