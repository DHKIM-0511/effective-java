package com.nrz.efj.chapter07.item50;

import java.util.Date;

/**
 * 불변 처럼 보이며, end가 start 뒤여야하는 규칙이 지켜질 것 같다.
 * Date가 가변이라는 사실을 이용하면 이를 꺠뜨릴 수 있다.
 * */
public final class Period {
    private final Date start;
    private final Date end;

    /**
    * @param start 시작 시각
    * @param end 종료 시각; 시작 시각보다 뒤여야한다
    * @throws IllegalArgumentException 시작 시각이 종료 시각보다 늦을 때 발생
     * @throws NullPointerException start나 end가 null이면 발생
    * */
    public Period(Date start, Date end){
        if(start.compareTo(end) > 0)
            throw new IllegalArgumentException(start + "가" + end + "보다 늦다.");

        this.start = start;
        this.end = end;
    }
    public Date start(){return start;}
    public Date end(){return end;}
    //...


    /**
     * 아래 문제는 java 8 부터는 Instant를 사용하면 해결 가능. (LocalDateTime, ZonedDateTime 도 가능)
     * Date는 낡은 API라 더 이상 사용 하지말자.
     * 하지만 여전히 많은 API와 내부 구현에 아래 문제같은 잔재들이 남아있다
     * */
    public static void main(String[] args) {
        Date start = new Date();
        Date end = new Date();
        Period p = new Period(start, end);
        end.setTime(1); // p 내부 수정
    }
}
