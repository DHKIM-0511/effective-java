package com.nrz.efj.chapter04.item31;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.EmptyStackException;
import java.util.List;

public class Stack<E> {
    private E[] elements;
    private int size;
    private static final int DEFAULT_INITIAL_CAPACITY = 16;

    @SuppressWarnings("unchecked")
    public Stack() {
        this.elements = (E[]) new Object[DEFAULT_INITIAL_CAPACITY];
    }

    public void push(E e){
        ensureCapacity();
        elements[size++] = e;
    }

    public E pop(){
        if(size == 0) throw new EmptyStackException();
        E res = elements[--size];
        elements[size] = null;
        return res;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    private void ensureCapacity(){
        if(elements.length == size) elements = Arrays.copyOf(elements, 2 * size +1);
    }

//    public void pushAll(Iterable<E> src){
//        for(E e: src) push(e);
//    }

//   producer 함수에 한정적 와일드카드 타입 적용
    public void pushAll(Iterable<? extends E> src){
        for(E e: src) push(e);
    }

//    public void popAll(Collection<E> dst){
//        while (!isEmpty()) dst.add(pop());
//    }

//  consumer 함수에 한정적 와일드카드 타입 적용
    public void popAll(Collection<? super E> dst){
        while (!isEmpty()) dst.add(pop());
    }

    public static void main(String[] args) {
        Stack<Number> stack = new Stack<>();
        Iterable<Integer> integers = Arrays.asList(3,1,4,1,5,9);
        stack.pushAll(integers);

        Collection<Object> objects = new ArrayList<>();
        stack.popAll(objects);
    }
}
