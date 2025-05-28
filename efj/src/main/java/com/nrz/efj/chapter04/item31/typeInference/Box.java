package com.nrz.efj.chapter04.item31.typeInference;

public class Box<T>{
    protected T value;

    @Override
    public String toString() {
        return "Box{" +
            "value=" + value +
            '}';
    }

    public void set(T u) {
        this.value = u;
    }

    public T get() {
        return this.value;
    }
}
