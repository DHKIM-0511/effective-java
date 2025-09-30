package com.nrz.efj.chapter06.item43;

import java.util.HashMap;
import java.util.Map;

/**
 * 메서드 레퍼런스는 파라미터의 이름이 없다
 * 람다의 파라미터 이름이 개발자에게 좋은 가이드로 작용할 수 있다. -> 유지보수
 * 람다로 할 수 없다면 메서드 참조로도 불가능하다.(하나의 예외만 빼고)
 *
 * 람다대신 메서드를 만들어 참조하고 해당 메서드로 이름을 짓거나, 문서화 하여 람다 좋은 대안으로 쓸 수 있다.
 * */
public class MethodRef {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>(Map.of("a",1,"b",0,"c",0));
        for(String key: map.keySet()){
            /*
            * 이 코드의 값이 키의 인스턴스 개수로 해석된다면 이는 멀티셋을 구현한 것
            * 깔끔해보이지만, count와 incr은 저장 공간을 꽤 차지한다
            * MethodReference 를 사용하자
            *
            * 이처럼 파라미터가 많으면 메서드 레퍼런스로 제거할 수 있는 코드양도 늘어난다.
            **/
//            map.merge(key, 1, (count, incr) -> count + incr);
            map.merge(key, 1, Integer::sum);
        }
        System.out.println(map);
    }
}
