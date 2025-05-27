package com.nrz.efj.chapter04.item28.arry_to_list;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Chooser_Array<T> {
    private final List<T> choiceList;

    public Chooser_Array(Collection<T> choices) {
        this.choiceList = new ArrayList<>();
    }

    public Object choose(){
        Random random = ThreadLocalRandom.current();
        return choiceList.get(random.nextInt(choiceList.size()));
    }

    public static void main(String[] args) {
        List<Integer> intList = List.of(1,2,3,4,5);

        Chooser_Array<Integer> chooser = new Chooser_Array<>(intList);
        for(int i = 0 ; i <  10 ; i++){
            Number choice = (Number) chooser.choose();
            System.out.println(choice);
        }
    }
}
