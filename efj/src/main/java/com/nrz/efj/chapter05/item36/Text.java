package com.nrz.efj.chapter05.item36;

/**
 *  비트 필드 열거 상수 (구닥다리)
 *  정수 열거 타입의 단점을 그대로 갖는다.
 *  추가로 비트 필드 값을 보고 의미를 알기 어렵다.
 *
 *  더 나은 대안이 있다 {@link BetterText}
 * */
public class Text {
    public static final int STYLE_BOLD = 1 << 0;
    public static final int STYLE_ITALIC = 1 << 1;
    public static final int STYLE_UNDERLINE = 1 << 2;
    public static final int STYLE_STRIKETHROUGH = 1 << 3;

    public void applyStyles(int styles){
        //...
    }

    public static void main(String[] args) {
        Text text = new Text();

        //합집합, 교집합같은 여러 상태를 동시에 적용하기 편하다
        text.applyStyles(STYLE_BOLD | STYLE_ITALIC);


    }
}
