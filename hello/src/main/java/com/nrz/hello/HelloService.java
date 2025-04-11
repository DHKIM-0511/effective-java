package com.nrz.hello;

public interface HelloService {
    String hello();

    //1. 반환 타입을 인터페이스(부모 클래스)로 두면 하위 구현체를 리턴할 수 있어서 유연함
    //2. 인터페이스에 static 메서드 사용가능 -> 구현체나 factory class에 정적 메서드 많이 안만들어도 된다.
    //3. 입력 매개변수에 따라 유연하게 다른클래스의 객체를 반환할 수 있다
    static HelloService of(String lang){
        if(lang.equals("ko")){
            return new KoreanHelloService();
        }else {
            return new EnglishHelloService();
        }
    }

    static String hi() {
        prepareMessage();
        return "hi";
    }

    static private void prepareMessage() {
    }

    static String hi1() {
        prepareMessage();
        return "hi";
    }

    static String hi2() {
        prepareMessage();
        return "hi";
    }

    default String bye() {
        return "bye";
    }
}
