package com.nrz.efj.chapter01.item07.optional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Channel {
    private int numOfSubscribers;

    public Optional<MemberShip> defaultMemberShip(){
        if(this.numOfSubscribers < 2000){
            //예외 던지기 or null 반환 or Optional 활용
            return Optional.empty();
        }else {
            return Optional.of(new MemberShip());
        }
    }
}
