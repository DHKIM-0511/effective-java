package com.nrz.efj.chapter05.item37;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * ordinal 메서드로 인덱스를 얻는 코드는 안좋다.
 * EnumMap은 내부적으로 배열을 사용하므로 성능이 좋다
 * */
public class Plant {
    enum LifeCycle{ANNUAL, PERENNIAL, BIENNIAL}

    final String name;
    final LifeCycle lifeCycle;

    Plant(String name, LifeCycle lifeCycle){
        this.name = name;
        this.lifeCycle = lifeCycle;
    }

    @Override public String toString(){
        return name;
    }

    public static void main(String[] args) {
        Plant[] garden = {
            new Plant("Rose", Plant.LifeCycle.PERENNIAL),
            new Plant("Tomato", Plant.LifeCycle.ANNUAL),
            new Plant("Carrot", Plant.LifeCycle.BIENNIAL),
            new Plant("Tulip", Plant.LifeCycle.PERENNIAL),
            new Plant("Lettuce", Plant.LifeCycle.ANNUAL)
        };
        /*
        * ordinal을 배열의 인덱로 활용
        * 제네릭 활용x -> 비검사 타입 캐스팅 문제
        * 배열은 각 인덱스의 의미가 없음 -> 라벨을 달아야함
        * 정확한 정수값을 사용하는것을 보증해야함.
        * */
        Set<Plant>[] plantsByLifeCycle = (Set<Plant>[]) new Set[LifeCycle.values().length];
        for(int i = 0 ; i < plantsByLifeCycle.length ; i++){
            plantsByLifeCycle[i] = new HashSet<>();
        }
        for(Plant p : garden){
            plantsByLifeCycle[p.lifeCycle.ordinal()].add(p);
        }

        for(int i = 0 ; i < plantsByLifeCycle.length; i++){
            System.out.printf("%s: %s%n",
                Plant.LifeCycle.values()[i], plantsByLifeCycle[i]);
        }

        /*
         * EnumMap을 활용하자
         * 안전한 타입 캐스팅
         * 인덱스 계산할필요 x -> 오류 x
         * 생성자의 키 타입 class객체 = 한정적 타입 토큰 -> 런타임 제네릭 타입 정보 제공
         * */
        Map<LifeCycle, Set<Plant>> plantsByLifeCycleMap = new EnumMap<>(LifeCycle.class);
        for(LifeCycle lc : LifeCycle.values()) plantsByLifeCycleMap.put(lc, new HashSet<>());
        for(Plant p : garden) plantsByLifeCycleMap.get(p.lifeCycle).add(p);

        System.out.println(plantsByLifeCycleMap);

        /*
        * Stream 코드
        * 이전과 달리, 해당 LifeCycle에 해당하는 식물이 garden에 있을때만 만든다.
        * */
        System.out.println(Arrays.stream(garden)
            .collect(Collectors.groupingBy(p -> p.lifeCycle,
                () -> new EnumMap<>(LifeCycle.class), Collectors.toSet())));
    }
}
