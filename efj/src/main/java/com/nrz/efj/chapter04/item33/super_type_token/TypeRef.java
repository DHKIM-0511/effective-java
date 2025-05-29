package com.nrz.efj.chapter04.item33.super_type_token;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Objects;

public abstract class TypeRef<T> {
    private final Type type;

    protected TypeRef(){
        ParameterizedType superclass = (ParameterizedType) getClass().getGenericSuperclass();
        type = superclass.getActualTypeArguments()[0];
    }

    @Override
    public boolean equals(Object o){
        return o instanceof TypeRef && ((TypeRef) o).type.equals(type);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(type);
    }

    public Type getType() {
        return type;
    }
}
