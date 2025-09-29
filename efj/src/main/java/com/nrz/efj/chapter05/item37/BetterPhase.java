package com.nrz.efj.chapter05.item37;


import java.util.EnumMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum BetterPhase {
    SOLID, LIQUID, GAS;

    public enum  Transition{
        MELT(SOLID, LIQUID), FREEZE(LIQUID, SOLID),
        BOIL(LIQUID, GAS), CONDENSE(GAS, LIQUID),
        SUBLIME(SOLID, GAS), DEPOSIT(GAS, SOLID);

        private final BetterPhase from;
        private final BetterPhase to;

        Transition(BetterPhase from, BetterPhase to){
            this.from = from;
            this.to = to;
        }

        private static final Map<BetterPhase, Map<BetterPhase, Transition>>
            m = Stream.of(values()).collect(Collectors.groupingBy(t -> t.from, // transition을 이전 상태 기준으로 묶음
            () -> new EnumMap<>(BetterPhase.class),
            Collectors.toMap(t -> t.to, t -> t, // 이후 상태를 키로 만들고  transition을 담는다.
                (x,y) -> y, () -> new EnumMap<>(BetterPhase.class))));


        public static Transition from(BetterPhase from, BetterPhase to){
            return m.get(from).get(to);
        }
    }
}
