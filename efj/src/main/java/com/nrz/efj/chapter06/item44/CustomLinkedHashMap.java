package com.nrz.efj.chapter06.item44;

import java.util.LinkedHashMap;
import java.util.Map;

public class CustomLinkedHashMap<K, V> extends LinkedHashMap<K, V> {
    private final EldestEntryRemovalFunction<K, V> removalPolicy;

    public CustomLinkedHashMap(EldestEntryRemovalFunction<K,V> removalPolicy){
        super(16, 0.75f, true);
        this.removalPolicy = removalPolicy;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<K,V> eldest){
        return removalPolicy.remove(this, eldest);
    }
}
