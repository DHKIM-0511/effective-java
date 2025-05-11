package com.nrz.efj.chapter03.item15.class_and_interfaces.member;

import java.util.Arrays;

class DefaultMemberService implements MemberService{
    private String name;

    private static class PrivateStaticClass{

    }

    private class PrivateClass{

    }

    public static void main(String[] args) {
//        Arrays.stream(PrivateClass.class.getDeclaredFields()).forEach(System.out::println);
        Arrays.stream(PrivateStaticClass.class.getDeclaredFields()).forEach(System.out::println);
        Arrays.stream(MemberRepository.class.getDeclaredFields()).forEach(System.out::println);
    }

    /*
    * package-private 으로 선언 -> 외부 패키지에서 접근하지 못한다, 접근할 이유가 없다
    * MemberService에서 모든걸 제공하겠다
    * -> 한곳에서만 사용한다면 해당 클래스의 내부에서 private static하게 사용하자
    * */
    private interface MemberRepository {

    }
}
