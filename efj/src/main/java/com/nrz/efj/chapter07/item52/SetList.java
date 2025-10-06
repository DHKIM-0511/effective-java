package com.nrz.efj.chapter07.item52;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * lst.remove((Integer)i); 가 다중 정의되어있어 헷갈리는 동작 중하나
 * 자바 4까지는 제네릭이 없어서 Object와 int가 근본적으로 달라 문제 없었다.
 * 제네릭과 오토박싱의 등장으로 캐스팅이 가능해지며 문제가 발생함 -> 다중 정의에 주의하자
 * */
public class SetList {

    public static void main(String[] args) {
        Set<Integer> set = new TreeSet<>();
        List<Integer> lst = new ArrayList<>();

        for(int i = -3; i< 3 ; i++){
            set.add(i);
            lst.add(i);
        }

        for(int i = 0 ; i < 3 ; i++){
            set.remove(i);
            lst.remove((Integer)i);
        }

        System.out.println(set+" "+lst);
    }
}
