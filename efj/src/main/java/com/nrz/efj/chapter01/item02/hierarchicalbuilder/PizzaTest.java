package com.nrz.efj.chapter01.item02.hierarchicalbuilder;

import static com.nrz.efj.chapter01.item02.hierarchicalbuilder.NyPizza.Size.SMALL;
import static com.nrz.efj.chapter01.item02.hierarchicalbuilder.Pizza.Topping.*;

public class PizzaTest {
    public static void main(String[] args) {
        NyPizza pizza = new NyPizza.Builder(SMALL)
            .addTopping(SAUSAGE)
            .addTopping(ONION).build();

        Calzone calzone = new Calzone.Builder()
            .addTopping(HAM).sauceInside().build();

        System.out.println(pizza);
        System.out.println(calzone);
    }
}
