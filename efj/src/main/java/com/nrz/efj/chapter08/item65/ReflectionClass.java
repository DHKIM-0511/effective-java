package com.nrz.efj.chapter08.item65;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.Set;

/**
 * 간단하지만 꽤나 강력한 기법이다.
 * 명시한 Set 구현체를 공격적으로 조작해보며 Set 규약을 잘 지키는지 검사할 수 있다.
 * 제네릭 Set 성능 분석 도구로 활용할 수 있다.
 * 대부분 리플렉션은 이 정도만 사용해도 충분하다
 */
public class ReflectionClass {

    public static void main(String[] args) {
        Class<? extends Set<String>> cl = null;

        //클래스 이름을 Class 객체로 변환
        try{
            cl = (Class<? extends Set<String>>) Class.forName(args[0]);
        }catch (ClassNotFoundException e){
            fatalError("클래스를 찾을 수 없습니다.");
        }

        //생성자를 얻는다
        Constructor<? extends Set<String>> cons = null;
        try {
            cons = cl.getDeclaredConstructor();
        } catch (NoSuchMethodException e) {
            fatalError("매개변수 없는 생성자를 찾을 수 없습니다.");
        }

        //집합의 인스턴스를 만든다
        Set<String> s = null;
        try {
            s = cons.newInstance();
        }catch (IllegalAccessException e){
            fatalError("생성자에 접근할 수 없습니다.");
        }catch (InstantiationException e){
            fatalError("클래스를 인스턴스화 할 수 없습니다.");
        }catch (InvocationTargetException e){
            fatalError("생성자가 예외를 던졌습니다.: " + e.getCause());
        }catch (ClassCastException e){
            fatalError("Set을 구현하지 않는 클래스입니다.");
        }

        s.addAll(Arrays.asList(args).subList(1, args.length));
        System.out.println(s);
    }

    private static void fatalError(String msg){
        System.err.println(msg);
        System.exit(1);
    }
}
