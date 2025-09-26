package com.nrz.efj.chapter05.item34;

/**
 * 열거 타입 상수를 각각 특정 데이터와 연관지으려면, 생성자에서 받아 필드에 저장한다.
 * private 으로 두고 public 접근자를 만들자
 * 자주 쓰이는 값을 생성자 단계에서 미리 계산해서 넣을 수 있다
 * 명왕성이 태양계에서 사라져도 오류가 없음 (명왕성을 참조하는 클라이언트 코드는 적절한 예외 발생)
 * 클라이언트에게 노출할 이유가 없다면 private으로 작성하자
 * 널리 쓰이는 Enum은 톱 레벨로, 아니라면 멤커 Enum으로 만들자 -> 일관성
 * 지금은 단순히 다른 데이터와 연관/ 데이터마다 다른 동작을 구현하는것도 가능 (계산기)
 * */
public enum Planet {
    MERCURY(3.302e+23, 2.439e6),
    VENUS(4.869e+24, 6.052e6),
    EARTH(5.975e+24, 6.378e6),
    MARS(6.419e+23, 3.393e6)
    //... other planets
    ;

    private final double mass;              // 질량 (단위: Kg)
    private final double radius;            // 반지름 (단위: 미터)
    private final double surfaceGravity;    // 표면중력 (단위: m/s^2)

    //중력 상수 (단위: m^3/kg s^2)
    private final double G = 6.67300E-11;

    Planet(double mass, double radius){
        this.mass = mass;
        this.radius = radius;
        surfaceGravity = G * mass / (radius * radius);
    }

    public double mass(){ return mass;}
    public double radius(){ return radius;}
    public double surfaceGravity(){ return surfaceGravity;}

    public double surfaceWeight(double mass){
        return mass * surfaceGravity;
    }

    public static void main(String[] args) {
        double earthWeight = Double.parseDouble("185");
        double mass = earthWeight / Planet.EARTH.surfaceGravity();
        for(Planet p : Planet.values()){
            System.out.printf("%s에서의 무게는 %f이다. %n",
                                p, p.surfaceWeight(mass));
        }
    }
}
