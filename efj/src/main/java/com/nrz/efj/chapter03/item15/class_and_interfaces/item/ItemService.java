package com.nrz.efj.chapter03.item15.class_and_interfaces.item;

import com.nrz.efj.chapter03.item15.class_and_interfaces.member.MemberService;

public class ItemService {

    //테스트를 위해 package private 으로 변경해도 괜찮음
    MemberService memberService;
    boolean osSale;
    protected int saleRate;
    public static final String NAME = "nrz";

    //이건 권장 x => 배열 내 원소가 변경될 수 있으므로
    public static final String[] NAMES = new String[2];

    public ItemService(MemberService memberService){
        if(memberService == null){
            throw new IllegalArgumentException("MemberService must not be null");
        }
        this.memberService = memberService;
    }

    //테스트를 위해 package private getter를 만들어도 괜찮다
//    MemberService getMemberService() {
//        return memberService;
//    }
}

