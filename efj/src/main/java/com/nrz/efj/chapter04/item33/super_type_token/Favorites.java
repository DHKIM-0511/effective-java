package com.nrz.efj.chapter04.item33.super_type_token;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Favorites {
    private Map<TypeRef<?>, Object> favorites = new HashMap<>();

    public <T> void put(TypeRef<T> typeRef, T thing){
        favorites.put(typeRef, thing);
    }

    public <T> T get(TypeRef<T> typeRef){
        return (T) favorites.get(typeRef);
    }

    public static void main(String[] args) {
        Favorites favorites = new Favorites();

        favorites.put(new TypeRef<List<String>>() {}, List.of("a","b","c"));
        favorites.put(new TypeRef<List<Integer>>() {}, List.of(1,2,3));
        favorites.get(new TypeRef<List<String>>() {}).forEach(System.out::println);
        favorites.get(new TypeRef<List<Integer>>() {}).forEach(System.out::println);
    }
}
