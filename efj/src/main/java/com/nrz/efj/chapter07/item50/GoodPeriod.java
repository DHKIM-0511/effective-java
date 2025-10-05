package com.nrz.efj.chapter07.item50;

import java.util.Date;

public class GoodPeriod {
    private final Date start;
    private final Date end;

    public GoodPeriod(Date start, Date end){
        this.start = new Date(start.getTime());
        this.end = new Date(end.getTime());

        if(start.compareTo(end) > 0)
            throw new IllegalArgumentException(start + "가" + end + "보다 늦다.");
    }
    public Date start(){return start;}
    public Date end(){return end;}


    /**
     * 아직도 Period 변경이 가능하다 → 접근자 메서드가 내부의 가변 정보를 직접 드러내기 때문
     * 해결방법: 가변 필드의 방어적 복사본을 반환하면 된다.
     * */
    public static void main(String[] args) {
        Date start = new Date();
        Date end = new Date();
        GoodPeriod gp = new GoodPeriod(start, end);
        gp.end().setTime(1);
    }
}
