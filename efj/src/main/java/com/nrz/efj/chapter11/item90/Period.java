package com.nrz.efj.chapter11.item90;

import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Date;

public class Period implements Serializable {
    private final Date start;
    private final Date end;

    public Period(Date start, Date end){
        this.start = new Date(start.getTime());
        this.end = new Date(end.getTime());

        if(start.compareTo(end) > 0)
            throw new IllegalArgumentException(start + "가" + end + "보다 늦다.");
    }

    public Date start(){return new Date(start.getTime());}
    public Date end(){return new Date(end.getTime());}
    public String toString() {return start + "-" + end;}
    //...

    private void readObject(ObjectInputStream stream)throws InvalidObjectException{
        throw new InvalidObjectException("프록시가 필요합니다.");
    }

    //직렬화 프록시 패턴
    private static class SerializationProxy implements Serializable{
        private final Date start;
        private final Date end;
        SerializationProxy(Period p){
            this.start = p.start;
            this.end = p.end;
        }
        //아무 값이나 상관없다
        private static final long serialVersionUID = 1239765123987L;
    }
    /*
    * 직렬화 프록시 패턴용 메서드
    * 자바의 직렬화 시스템이 바깥 클래스의 인스턴스 대신 SerializationProxy의 인스턴스를 반환하게한다
    * 즉, 직렬화가 이뤄지기전에 바깥 클래스의 인스턴스를 직렬화 프록시로 변환해준다.
    * writeReplace덕분에 직렬화 시스템은 결코 바깥 클래스의 직렬화된 인스턴스를 생성해낼 수 없다.
    *
    * 하지만 공격자는 불변식을 훼손하고자 이런 시도를 해볼 수 있다.
    *
    * */
    private Object writeReplace(){
        return new SerializationProxy(this);
    }

    private Object readResolve(){
        return new Period(start, end);
    }
}
