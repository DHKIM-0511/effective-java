package com.nrz.efj.chapter03.item17.pros_and_cons;

import com.nrz.efj.chapter03.item16.point.method.Point;
import java.math.BigInteger;
import java.util.HashSet;
import java.util.Set;

public class BigIntExample {

    public static void main(String[] args) {
        BigInteger ten = BigInteger.TEN;
        BigInteger minusTen = ten.negate();

        Set<Point> points = new HashSet<>();
        Point fisrtPoint = new Point(1, 2);
        points.add(fisrtPoint);
    }
}
