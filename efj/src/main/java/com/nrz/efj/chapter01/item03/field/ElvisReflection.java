package com.nrz.efj.chapter01.item03.field;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class ElvisReflection {
    public static void main(String[] args) {
        try {
            Constructor<Elvis> defaultConstructor = Elvis.class.getDeclaredConstructor(); // 접근 제한자와 상관없이 생성자에 접근 가능
            defaultConstructor.setAccessible(true);
            Elvis elvis1 = defaultConstructor.newInstance();
            Elvis elvis2 = defaultConstructor.newInstance();
            Elvis.INSTANCE.sing();
        } catch (InvocationTargetException | NoSuchMethodException | InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
