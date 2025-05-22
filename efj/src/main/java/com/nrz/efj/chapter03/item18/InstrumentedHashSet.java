package com.nrz.efj.chapter03.item18;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;

public class InstrumentedHashSet<E> extends HashSet<E> {
    private int addCount = 0;

    public InstrumentedHashSet(){}

    public InstrumentedHashSet(int initCap, float loadFactor){super(initCap, loadFactor);}

    @Override public boolean add(E e){
        addCount++;
        return super.add(e);
    }

    @Override public boolean addAll(Collection<? extends E> c){
        addCount += c.size();
        return super.addAll(c);
    }

    public int getAddCount(){
        return addCount;
    }

    /*
    * 상속을 사용한다면 상위 클래스의 구체적인 구현을 알아야함.
    * 또한 메서드 변경이나 추가 등을 지속적으로 따라가면서 내 클래스의 구현을 점검 및 수정해야함. => 캡슐화 문제
    * 대안 => 컴포지션
    * */
    public static void main(String[] args) {
        InstrumentedHashSet<String> s = new InstrumentedHashSet<>();
        s.addAll(List.of("틱", "탁탁", "펑"));
        System.out.println(s.getAddCount());
    }
}
