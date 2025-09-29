package com.nrz.efj.chapter05.item37;

/**
 * 배열의 인덱스에 ordinal을 사용하지 말자
 * Phase, Transition을 수정하면 모두 함께 수정해야한다
 * 런타임 오류(OOB, NPE 등..)를 던질 수 있다.
 * 상태가 늘어나면 배열도 커지고, null 칸도 많아진다
 *
 * 따라서 EnumMap을 사용하자 {@link BetterPhase }
 * */
public enum Phase {
    SOLID, LIQUID, GAS;

    public enum  Transition{
        MELT, FREEZE, BOIL, CONDENSE, SUBLIME, DEPOSIT;

        private static final Transition[][] TRANSITIONS = {
            {null, MELT, SUBLIME},
            {FREEZE, null, BOIL},
            {DEPOSIT, CONDENSE, null}
        };

        public static Transition from(Phase from, Phase to){
            return TRANSITIONS[from.ordinal()][to.ordinal()];
        }
    }
}
