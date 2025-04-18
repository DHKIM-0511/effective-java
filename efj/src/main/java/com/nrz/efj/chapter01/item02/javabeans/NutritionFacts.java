package com.nrz.efj.chapter01.item02.javabeans;

import java.io.Serializable;

// 자바빈즈 패턴은 일관성이 깨지고, 불변으로 만들 수 없다.
public class NutritionFacts implements Serializable {
    // 필드 (기본값이 있다면) 기본값으로 초기화된다.
    private int servingSize  = -1; // 필수; 기본값 없음
    private int servings     = -1; // 필수; 기본값 없음
    private int calories     = 0;
    private int fat          = 0;
    private int sodium       = 0;
    private int carbohydrate = 0;
    private boolean healthy;

    public NutritionFacts() {}

    public void setServingSize(int servingSize){this.servingSize = servingSize;}

    public void setServings(int servings){this.servings = servings;}

    public void setCalories(int calories){this.calories = calories;}

    public void setFat(int fat){this.fat = fat;}

    public void setSodium(int sodium){this.sodium = sodium;}

    public void setCarbohydrate(int carbohydrate) {
        this.carbohydrate = carbohydrate;
    }

    public void setHealthy(boolean healthy) {
        this.healthy = healthy;
    }

    public static void main(String[] args) {
        NutritionFacts cocaCola = new NutritionFacts();
        cocaCola.setServingSize(240);
        cocaCola.setServings(8);

        cocaCola.setCalories(100);
        cocaCola.setSodium(35);
        cocaCola.setCarbohydrate(27);
        /*
        * 세터로 값을 설정하기 전에 인스턴스가 쓰일 수 있는 위험이있다
        *
        * 필수 객체를 생성자에서 반드시 받도록한다고해도 단점이 있다.
        * -> 불변객체로 만들 수 없음
        * */
    }
}
