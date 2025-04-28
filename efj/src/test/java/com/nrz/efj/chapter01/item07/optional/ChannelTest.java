package com.nrz.efj.chapter01.item07.optional;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Optional;
import org.junit.jupiter.api.Test;

class ChannelTest {

    @Test
    void npe(){
        Channel channel = new Channel();
        Optional<MemberShip> optional = channel.defaultMemberShip();
        optional.ifPresent(MemberShip::hello);
    }

}