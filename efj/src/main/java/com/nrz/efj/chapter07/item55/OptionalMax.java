package com.nrz.efj.chapter07.item55;

import java.util.Collection;
import java.util.Comparator;
import java.util.Objects;
import java.util.Optional;

public class OptionalMax {
    public static <E extends Comparable<E>> Optional<E> max(Collection<E> c){
        if(c.isEmpty()) return Optional.empty();

        E result = null;
        for(E e: c)
            if(result == null || e.compareTo(result) > 0)
                result = Objects.requireNonNull(e);

        return Optional.of(result);
    }
    public static <E extends Comparable<E>> Optional<E> maxWithStream(Collection<E> c){
        return c.stream().max(Comparator.naturalOrder());
    }
}
