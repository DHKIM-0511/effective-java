package com.nrz.efj.chapter03.item16.dimension;

import java.awt.Button;
import java.awt.Dimension;

public class DimensionExample {

    public static void main(String[] args) {
        Button button = new Button();
        button.setBounds(0, 0, 20, 10);

        Dimension size = button.getSize();
        /*
        * Dimension class 필드는 public
        * 활용시 Copy가 필연적 -> 성능 문제 야기 (수백만개)
        * */
        System.out.println(size.height);
        System.out.println(size.width);
    }
}
