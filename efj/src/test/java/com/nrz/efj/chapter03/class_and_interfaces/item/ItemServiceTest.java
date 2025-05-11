package com.nrz.efj.chapter03.class_and_interfaces.item;

import static org.junit.jupiter.api.Assertions.*;

import com.nrz.efj.chapter03.item15.class_and_interfaces.item.ItemService;
import com.nrz.efj.chapter03.item15.class_and_interfaces.member.MemberService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class ItemServiceTest {

    @Mock
    MemberService memberService;

    @Test
    void itemServiceConstructor(){
        ItemService service = new ItemService(memberService);
        assertNotNull(service);
        assertNotNull(service.memberService);
    }
}