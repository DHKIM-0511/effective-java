package com.nrz.efj.chapter01.item02.builder;

/*
* 빌더 패턴은 점층적 생성자 패턴과 자바빈즈 패턴의 장점만 취했다.
* 코드의 복잡성이 늘어나고, 필드들이 늘어나는 오버헤드가 있으므로 반드시 좋은코드는아니다.
* 따라서 필드가 너무 많고, 불변성이 필요하다면 적용하는것이 좋다
* */
public class NutritionFacts {
    private final int servingSize;
    private final int servings;
    private final int calories;
    private final int fat;
    private final int sodium;
    private final int carbohydrate;

    public static class Builder {
        //필수 필드
        private final int servingSize;
        private final int servings;


        //선택 필드
        private int calories = 0;
        private int fat = 0;
        private int sodium = 0;
        private int carbohydrate = 0;

        public Builder(int servingSize, int servings){
            this.servingSize = servingSize;
            this.servings = servings;
        }

        public Builder calories(int calories){
            this.calories = calories; return this;
        }
        public Builder fat(int fat){
            this.fat = fat; return this;
        }
        public Builder sodium(int sodium){
            this.sodium = sodium; return this;
        }
        public Builder carbohydrate(int carbohydrate){
            this.carbohydrate = carbohydrate; return this;
        }

        public NutritionFacts build(){return new NutritionFacts(this);}
    }

    private NutritionFacts(Builder builder){
        servingSize = builder.servingSize;
        servings = builder.servings;
        calories = builder.calories;
        fat = builder.fat;
        sodium = builder.sodium;
        carbohydrate = builder.carbohydrate;
    }

    public static void main(String[] args) {
        NutritionFacts cocaCola = new Builder(240, 8)
            .calories(0)
            .sodium(22)
            .carbohydrate(123).build();
    }
}
