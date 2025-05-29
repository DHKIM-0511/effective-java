package com.nrz.efj.chapter04.item33.super_type_token;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public class GenericTypeInfer {
    static class Super<T>{
        T value;
    }

//    static class Sub extends Super<String>{
//
//    }

    public static void main(String[] args) throws NoSuchFieldException {
        Super<String> stringSuper = new Super<>();
        System.out.println(stringSuper.getClass().getDeclaredField("value").getType());

//        Type type = Sub.class.getGenericSuperclass();
        Type type = (new Super<String>(){}).getClass().getGenericSuperclass();
        ParameterizedType pType = (ParameterizedType) type;
        System.out.println(pType.getActualTypeArguments()[0]);
    }
}
