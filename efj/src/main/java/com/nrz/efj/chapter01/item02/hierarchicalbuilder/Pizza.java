package com.nrz.efj.chapter01.item02.hierarchicalbuilder;

// 계층적으로 설계된 클래스와 잘 어울리는 빌더 패턴

import java.util.EnumSet;
import java.util.Objects;
import java.util.Set;

// 참고: 여기서 사용한 '시뮬레이트한 셀프 타입(simulated self-type)' 관용구는
// 빌더뿐 아니라 임의의 유동적인 계층구조를 허용한다.
public abstract class Pizza {
    public enum Topping{ HAM, MUSHROOM, ONION, PEPPER, SAUSAGE }
    final Set<Topping> toppings;

    //재귀적인 타입제한
    abstract static class Builder<T extends Builder<T>>{
        EnumSet<Topping> toppings = EnumSet.noneOf(Topping.class);
        public T addTopping(Topping topping){
            //제네릭으로 해야 하위 클래스의 builder를 사용할 수 있고, 캐스팅을 줄일 수 있음
            toppings.add(Objects.requireNonNull(topping));
            return self();
        }

        abstract Pizza build();

        //하위 클래스에서 오버라이딩하여 this를 리턴하도록 해야한다.
        protected abstract T self();
    }

    Pizza(Builder<?> builder){toppings = builder.toppings.clone();}
}
