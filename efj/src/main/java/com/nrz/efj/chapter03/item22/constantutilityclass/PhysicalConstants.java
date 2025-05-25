package com.nrz.efj.chapter03.item22.constantutilityclass;

//인스턴스 생성 불가인 유틸리티 클래스로 값을 사용 권장
public final class PhysicalConstants {

    private PhysicalConstants() {
    }

    static final double AVOGADROS_NUMBER   = 6.022_140_857e23;

    static final double BOLTZMANN_CONSTANT = 1.380_648_52e-23;

    static final double ELECTRON_MASS      = 9.109_383_56e-31;
}
