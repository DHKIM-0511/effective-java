package com.nrz.efj.chapter04.item31.example;

public class Box <T extends Comparable<T>>implements Comparable<Box<T>>{
    protected final T value;

    public Box(T value) {
        this.value = value;
    }

    @SuppressWarnings("unchecked")
    @Override
    public int compareTo(Box o) {
        return this.value.compareTo((T)o.value);
    }

    @Override
    public String toString() {
        return "Box{" +
            "value=" + value +
            '}';
    }
}
