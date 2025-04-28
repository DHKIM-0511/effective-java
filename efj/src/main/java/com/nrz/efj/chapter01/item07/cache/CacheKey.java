package com.nrz.efj.chapter01.item07.cache;

import java.time.LocalDateTime;

/*
* WeakReference 객체를 안쓰고 Integer같은 Wrapper 클래스를 쓰면 gc가 안없앰(내부적으로 캐싱)
* */
public class CacheKey {
    private Integer value;

    private LocalDateTime created;

    public CacheKey(Integer value){
        this.value = value;
        this.created = LocalDateTime.now();
    }

    @Override
    public boolean equals(Object o){return this.value.equals(o);}

    @Override
    public int hashCode(){return this.value.hashCode();}

    public LocalDateTime getCreated(){return created;}

    @Override
    public String toString(){
        return "CacheKey{" +
            "value=" + value +
            ", created=" + created +
            '}';
    }


}
