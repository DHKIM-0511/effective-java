package com.nrz.efj.chapter11.item89;

import java.util.Arrays;

public enum Elvis {
    INSTANCE;
    private String[] favoriteSongs = {"Hound dog", "Heartbreak Hotel"};
    public void printFavorites(){
        System.out.println(Arrays.toString(favoriteSongs));
    }
}
