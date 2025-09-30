package com.nrz.efj.chapter06.item44;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.BiPredicate;

public class CustomLinkedHashMapWithBiPredicate<K, V> extends LinkedHashMap<K, V> {
    private final BiPredicate<K, V> removalPolicy;

    public CustomLinkedHashMapWithBiPredicate(BiPredicate<K,V> removalPolicy){
        super(16, 0.75f, true);
        this.removalPolicy = removalPolicy;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<K,V> eldest){
        return removalPolicy.test(eldest.getKey(), eldest.getValue());
    }
}
