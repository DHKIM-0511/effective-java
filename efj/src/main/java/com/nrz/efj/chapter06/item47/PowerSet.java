package com.nrz.efj.chapter06.item47;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * AbstractCollection 을 활용해서 Collection 구현체를 작성할 때는 Iterable용 메서드외에 2개만 더 구현하면 된다.
 * contains와 size. 이들은 손쉽게 효율적으로 구현 가능하다.
 * (반복이 시작되기 전에는 시퀀스의 내용을 확정할 수 없다는 사유로)
 * contains와 size를 구현하는게 불가능할 때는 컬렉션보다는 스트림이나 Iterable을 반환하는 편이 낫다. (두 방식 모두 제공 해도 된다)
 * */
public class PowerSet {
    public static final <E>Collection<Set<E>> of(Set<E> s){
        List<E> src = new ArrayList<>(s);

        if(src.size() > 30)
            throw new IllegalArgumentException("집합에 원소가 너무 많습니다(최대 30).: "+ s);

        return new AbstractList<Set<E>>(){
            @Override public int size(){
                return 1 << src.size();
            }

            @Override public boolean contains(Object o){
                return o instanceof Set && src.containsAll((Set) o);
            }

            @Override public Set<E> get(int index){
                Set<E> result = new HashSet<>();
                for(int i = 0; index != 0 ; i++, index >>= 1)
                    if((index & 1) == 1)
                        result.add(src.get(i));
                return result;
            }
        };
    }
}
