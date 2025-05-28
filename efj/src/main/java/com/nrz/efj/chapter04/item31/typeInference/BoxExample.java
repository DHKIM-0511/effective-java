package com.nrz.efj.chapter04.item31.typeInference;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BoxExample {
    private static <U> void addBox(U u, List<Box<U>> boxes){
        Box<U> box = new Box<>();
        box.set(u);
        boxes.add(box);
    }

    private static <U> void outputBoxes(List<Box<U>> boxes){
        int counter = 0;
        for(Box<U> box: boxes){
            U boxContents = box.get();
            System.out.println("Box #" + counter + " contains [" +
                boxContents.toString() + "]");
            counter++;
        }
    }
    private static void processStringList(List<String> stringList){

    }

    public static void main(String[] args) {
        ArrayList<Box<Integer>> listOfIntegerBoxes = new ArrayList<>();
        BoxExample.<Integer>addBox(10, listOfIntegerBoxes);
        BoxExample.addBox(20, listOfIntegerBoxes);
        BoxExample.addBox(30, listOfIntegerBoxes);

        //Target Type
        List<String> stringList = Collections.emptyList();
        List<Integer> integerList = Collections.emptyList();
        BoxExample.processStringList(Collections.emptyList());

    }
}
