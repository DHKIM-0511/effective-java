package com.nrz.efj.chapter03.item16.point.field;

public class Point {
    public double x;
    public double y;

    public static void main(String[] args) {
        Point point = new Point();
        point.x = 10;
        point.y = 20;

        doSomething(point);

        System.out.println(point.x);
        System.out.println(point.y);
    }

    //가변 객체를 쓸때는 복사해서 사용하자.
    private static void doSomething(Point point) {
        Point localPoint = new Point();
        localPoint.x = point.x;
        localPoint.y = point.y;
        // ...
    }
}
