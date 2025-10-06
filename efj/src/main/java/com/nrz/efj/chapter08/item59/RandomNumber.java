package com.nrz.efj.chapter08.item59;

import java.util.Random;

/**
 * 괜찮아 보이지만 세가지 문제가 있다.
 * 1. n이 그리 크지 않은 2의 제곱수라면 같은 수열이 반복된다.
 * 2. n이 2의 제곱수가 아니라면 몇몇 숫자가 평균적으로 더 자주 반환된다. n 값이 크면 이 현상이 더 두드러진다.
 * 3. 지정 범위 바깥 수가 종종 튀어나올 수 있다. -> Math.abs()로 음수가 아닌 정수로 매핑하기 때문.
 */
public class RandomNumber {
    static Random rnd = new Random();

    static int random(int n){
        return Math.abs(rnd.nextInt()) % n;
    }

    /**
     * 특정 범위에서 무작위 수를 백만개 생성 후 중간값 보다 작은 게 몇개인지 출력
     * -> random이 이상적이라면 약 50만개여야하지만
     * 실제로는 666666에 가까운 값을 얻는다.
     */
    public static void main(String[] args) {
        int n = 2 * (Integer.MAX_VALUE/ 3);
        int low = 0;
        for(int i = 0 ; i < 1000000; i++)
            if(random(n) < n/2) low++;

        System.out.println(low);
    }
}
