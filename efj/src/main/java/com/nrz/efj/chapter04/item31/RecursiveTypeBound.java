package com.nrz.efj.chapter04.item31;

import com.nrz.efj.chapter04.item31.example.IntegerBox;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

public class RecursiveTypeBound {
    public static <E extends Comparable<? super E>> E max(Collection<? extends E> c){
        if(c.isEmpty()) throw new IllegalArgumentException("빈 컬렉션입니다.");

        E result = null;
        for(E e: c)
            if(result == null || e.compareTo(result) > 0)
                result = Objects.requireNonNull(e);

        return result;
    }

    public static void main(String[] args) {
        List<IntegerBox> list = new ArrayList<>();
        list.add(new IntegerBox(1, "nrz"));
        list.add(new IntegerBox(2, "asd"));

        System.out.println(max(list));
    }
}
