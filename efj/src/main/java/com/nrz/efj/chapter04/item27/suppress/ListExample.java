package com.nrz.efj.chapter04.item27.suppress;

import java.util.Arrays;

public class ListExample {
    private int size;

    Object[] elements;

    public <T> T[] toArray(T[] a){
        if(a.length < size){
            /**
             * Annotation 추가 이유~
             */
            @SuppressWarnings("unchecked")
            T[] ts = (T[]) Arrays.copyOf(elements, size, a.getClass());

            return ts;
        }

        System.arraycopy(elements, 0, a, 0, size);
        if(a.length > size) a[size] = null;
        return a;
    }

    public static void main(String[] args) {

    }
}
