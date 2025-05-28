package com.nrz.efj.chapter04.item31.example;

public class IntegerBox extends Box<Integer>{

    private final String message;

    public IntegerBox(Integer value, String message) {
        super(value);
        this.message = message;
    }

    @Override
    public String toString() {
        return "IntegerBox{" +
            "message='" + message + '\'' +
            ", value=" + value +
            '}';
    }
}
