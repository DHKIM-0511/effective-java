package com.nrz.efj.chapter06.item45;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

/**
 * 사전에서 단어를 읽어 사용자가 지정한 문턱값보다 원소수가 많은 애너그램 그룹을 출력
 *
 * */
public class Anagrams {
    public static void main(String[] args) throws IOException {
        File dictionary = new File(args[0]);
        int minGroupSize = Integer.parseInt(args[1]);

        Map<String, Set<String>> groups = new HashMap<>();
        try(Scanner sc = new Scanner(dictionary)){
            while (sc.hasNext()){
                String word = sc.next();
                groups.computeIfAbsent(alphabetize(word)
                        ,(unused) -> new TreeSet<>()).add(word);
            }
        }
        for(Set<String> g: groups.values()){
            if (g.size() >= minGroupSize) {
                System.out.println(g.size() +": " + g);
            }
        }
    }

    private static String alphabetize(String s){
        char[] a = s.toCharArray();
        Arrays.sort(a);
        return new String(a);
    }
}
