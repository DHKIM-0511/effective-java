package com.nrz.efj.chapter03.item17.pros_and_cons;

import java.util.Objects;

public final class Complex {
    private final double re;
    private final double im;

    public static final Complex ZERO = new Complex(0,0);
    public static final Complex ONE = new Complex(1,0);
    public static final Complex I = new Complex(0,1);

    public Complex(double re, double im) {
        this.re = re;
        this.im = im;
    }

    public double realPart(){return re;}
    public double imaginaryPart() {return im;}

    public Complex plus(Complex c){
        return new Complex(re + c.re , im + c.im);
    }

    public static Complex valueOf(double re, double im){
        return new Complex(re, im);
    }
    public Complex minus(Complex c){
        return new Complex(re-c.re, im-c.im);
    }
    public Complex times(Complex c){
        return new Complex(re * c.re - im * c.im, re* c.im + im * c.re);
    }
    public Complex divideBy(Complex c){
        double tmp = c.re * c.re + c.im * c.im;
        return new Complex((re * c.re + im * c.im) / tmp,
            (im * c.re - re * c.im) / tmp);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Complex complex = (Complex) o;
        return Double.compare(re, complex.re) == 0
            && Double.compare(im, complex.im) == 0;
    }

    @Override
    public int hashCode() {
        return 31 * Double.hashCode(re) + Double.hashCode(im);
    }
}
