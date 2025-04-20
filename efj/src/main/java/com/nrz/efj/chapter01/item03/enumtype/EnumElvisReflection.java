package com.nrz.efj.chapter01.item03.enumtype;

import java.lang.reflect.Constructor;

public class EnumElvisReflection {
    public static void main(String[] args) {
        try {
            //ENUM은 리플렉션 방지되어있음
            Constructor<Elvis> declaredConstructor = Elvis.class.getDeclaredConstructor();
            System.out.println(declaredConstructor);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }
}
