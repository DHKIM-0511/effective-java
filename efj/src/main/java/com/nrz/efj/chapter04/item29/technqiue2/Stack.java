package com.nrz.efj.chapter04.item29.technqiue2;

import java.util.Arrays;
import java.util.EmptyStackException;
import java.util.List;

public class Stack<E> {
    private Object[] elements;
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
        @SuppressWarnings("unchecked") E res = (E) elements[--size];
        elements[size] = null;
        return res;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    private void ensureCapacity(){
        if(elements.length == size) elements = Arrays.copyOf(elements, 2 * size +1);
    }

    public static void main(String[] args) {
        Stack stack = new Stack();
        for(String arg: List.of("a","b","c")) stack.push(arg);
        while (!stack.isEmpty()) {
            System.out.println(((String) stack.pop()).toUpperCase());
        }
    }
}
