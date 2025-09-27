package com.nrz.efj.chapter05.item36;

import java.util.EnumSet;
import java.util.Set;

/**
 * EnumSet은 Set 인터페이스를 완벽히 구현
 * 타입 안전하고, 다른 Set구현체와도 함께 쓸 수 있다.
 *
 * 내부적으로 비트 벡터로 구현되었고, 원소가 64개이하라면 long 변수 하나로 표현하는것과 비견되는 성능을 보여준다.
 * removeAll, retainAll 같은 대량 작업은 비트를 효율적으로 처리할 수 있는 산술 연산을 써서 구현
 * 그러면서도 비트를 직접 다룰 때 겪는 문제에서 해방될 수 있다.
 * */
public class BetterText {
    public enum Style{BOLD, ITALIC, UNDERLINE, STRIKETHROUGH}

    //대부분 EnumSet을 쓰겠지만, 혹시 모를 호환성을 위해 인터페이스를 사용하는게 좋다
    public void applyStyles(Set<Style> styles){
        //...
    }

    public static void main(String[] args) {
        BetterText text = new BetterText();

        //비트 필드만큼 편하고, 타입 안전하며 효율적이다.
        text.applyStyles(EnumSet.of(Style.BOLD, Style.ITALIC));
    }
}
