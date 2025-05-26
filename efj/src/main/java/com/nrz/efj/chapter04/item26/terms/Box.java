package com.nrz.efj.chapter04.item26.terms;

public class Box<E> {
    private E item;

    private void add(E e){
        this.item = e;
    }

    private E get(){
        return this.item;
    }

    public static void main(String[] args){
        Box<Integer> box = new Box<>();
        box.add(10);
        printBox(box);
    }
    private static void printBox(Box<?> box){
        System.out.println(box.get());
    }
}
