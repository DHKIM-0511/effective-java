package com.nrz.efj.chapter05.item40;

import java.util.HashSet;
import java.util.Set;

/**
 * @Override가 필수는 아니지만, 오류를 줄일 수 있으므로 필히 명시하자.
 * (예외: 구체 클래스에서 상위 클래스의 추상메서드를 재정의할때는 안달아도 된다 -> 컴파일러가 알려주기 때문)
 * IDE에서 재정의 했지만 @Override가 없으면 경고를 띄울 수 있음
 * */
public class Bigram {
    private final char first;
    private final char second;

    public Bigram(char first, char second){
        this.first = first;
        this.second = second;
    }

    @Override public boolean equals(Object o){
        if(!(o instanceof Bigram)) return false;
        Bigram b = (Bigram) o;
        return b.first == first && b.second == second;
    }
    @Override public int hashCode(){
        return 31 * first + second;
    }

    public static void main(String[] args) {
        Set<Bigram> s = new HashSet<>();
        for(int i = 0 ; i < 10 ; i++){
            for(char ch = 'a'; ch <= 'z'; ch++) s.add(new Bigram(ch,ch));
        }
        System.out.println(s.size());
    }
}
