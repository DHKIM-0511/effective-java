package com.nrz.efj.chapter04.item28.erasure;

import java.util.ArrayList;
import java.util.List;

public class MyGeneric {

    public static void main(String[] args) {
        List<String> names = new ArrayList<>();
        names.add("nrz");
        String name = names.get(0);
        System.out.println(name);

        //실제로는 이런식으로 캐스팅해서 동작함 -> 제네릭은 실체화 되지 않는다
//        List names = new ArrayList();
//        names.add("nrz");
//        Object o = names.get(0);
//        String name = (String) o;
//        System.out.println(name);
    }
}
