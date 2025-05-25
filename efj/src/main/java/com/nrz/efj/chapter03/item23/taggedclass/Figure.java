package com.nrz.efj.chapter03.item23.taggedclass;

public class Figure {
    enum Shape{RECTANGLE, CIRCLE}

    //태그 필드 - 현재 모양
    final Shape shape;

    //사각형일때만 쓰이는 필드
    double length;
    double width;

    //원일때만 쓰이는 필드
    double radius;

    //원 생성자
    Figure(double radius){
        shape = Shape.CIRCLE;
        this.radius = radius;
    }

    //사각형 생성자
    public Figure(double length, double width) {
        shape = Shape.RECTANGLE;
        this.length = length;
        this.width = width;
    }

    double area(){
        switch (shape){
            case RECTANGLE:
                return length * width;
            case CIRCLE:
                return Math.PI * (radius * radius);
            default:
                throw new AssertionError(shape);
        }
    }
}
