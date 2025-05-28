package com.nrz.efj.chapter04.item31;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;

public class Chooser<T> {
    private final List<T> choiceList;
    private final Random random = new Random();

    public Chooser(Collection<? extends T> choices) {
        this.choiceList = new ArrayList<>();
    }

    public Object choose(){
        return choiceList.get(random.nextInt(choiceList.size()));
    }

    public static void main(String[] args) {
        List<Integer> intList = List.of(1,2,3,4,5);
        Chooser<Integer> chooser = new Chooser<>(intList);
        for(int i = 0 ; i <  10 ; i++){
            Number choice = (Number) chooser.choose();
            System.out.println(choice);
        }
    }
}
