package com.nrz.efj.chapter03.item23.hierarchy;


public class Rectangle extends  Figure{
    final double length;
    final double width;

     Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    @Override
    double area() {
        return length * width;
    }
}
