package com.nrz.efj.chapter01.item07.listener;

import static org.junit.jupiter.api.Assertions.*;

import java.lang.ref.WeakReference;
import java.util.List;
import org.junit.jupiter.api.Test;

class ChatRoomTest {
    @Test
    void chatRoom() throws InterruptedException{
        ChatRoom room = new ChatRoom();
        User user1 = new User();
        User user2 = new User();

        room.addUser(user1);
        room.addUser(user2);

        room.sendMessage("hello");

        user1 = null;

        System.gc();

        Thread.sleep(5000L);

        List<WeakReference<User>> users = room.getUsers();
        assertNotEquals(1, users.size());


    }
}