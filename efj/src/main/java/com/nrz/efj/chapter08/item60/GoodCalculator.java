package com.nrz.efj.chapter08.item60;

import java.math.BigDecimal;

/**
 * 올바른 값이 나오지만 두가지 단점이 있다
 * 1. 기본 타입보다 쓰기 훨씬 불편하고 느리다.
 *
 * 모든 계산을 정수로 처리하면 편하다 -> cent 기준 계산 {@link GooodCalculator}
 */
public class GoodCalculator {
    public static void main(String[] args) {
        final BigDecimal TEN_CENTS = new BigDecimal(".10");

        int itemsBought = 0;
        BigDecimal funds = new BigDecimal("1.00");
        for(BigDecimal price = TEN_CENTS;
            funds.compareTo(price) >= 0;
            price = price.add(TEN_CENTS)){
            funds = funds.subtract(price);
            itemsBought++;
        }

        System.out.println(itemsBought + "개 구입");
        System.out.println("잔돈(달러): " + funds);
    }
}
