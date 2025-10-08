package com.nrz.efj.chapter11.item88;

import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Date;

public class Period implements Serializable {
    private Date start;
    private Date end;

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

    //불변식 검사는 가능하지만, 가변 공격문제가 남아있다.
//    private void readObject(ObjectInputStream s) throws IOException, ClassNotFoundException{
//        s.defaultReadObject();
//
//        if(start.compareTo(end) > 0)
//            throw new InvalidObjectException(start +"가 " +end + "보다 늦다.");
//    }

    private void readObject(ObjectInputStream s) throws IOException, ClassNotFoundException{
        s.defaultReadObject();

        //가변 요소 방어적복사
        start = new Date(start.getTime());
        end = new Date(end.getTime());

        if(start.compareTo(end) > 0)
            throw new InvalidObjectException(start +"가 " +end + "보다 늦다.");
    }
}
