package com.nrz.efj.chapter03.item23.hierarchy;

public class Circle extends Figure{
    final double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    double area() {
        return Math.PI *(radius * radius);
    }
}
