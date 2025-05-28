package com.nrz.efj.chapter04.item33.type_token;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Favorites {
    private Map<Class<?>, Object> map = new HashMap<>();

    public <T> void put(Class<T> clazz, T value){
        this.map.put(Objects.requireNonNull(clazz), value);
    }

    public <T> T get(Class<T> clazz){
        return clazz.cast( this.map.get(clazz));
    }

    public static void main(String[] args) {
        Favorites favorites = new Favorites();
        favorites.put(String.class, "nrz");
        favorites.put(Integer.class, 2);
        String s = favorites.get(String.class);
        Integer i = favorites.get(Integer.class);
    }
}
