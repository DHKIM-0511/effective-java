package com.nrz.efj.chapter10.item79;

import com.nrz.efj.chapter03.item18.ForwardingSet;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;

public class ObservableSetWithCWList<E> extends ForwardingSet<E> {

    public ObservableSetWithCWList(Set<E> s) {
        super(s);
    }

    private final List<SetObserverWithCWList<E>> observers = new CopyOnWriteArrayList<>();
    public void addObserver(SetObserverWithCWList<E> observer){
        observers.add(observer);
    }

    public boolean removeObserver(SetObserverWithCWList<E> observer){
        return observers.remove(observer);
    }

    private void notifyElementAdded(E e){
        for(SetObserverWithCWList<E> observer: observers){
            observer.added(this, e);
        }
    }

    @Override public boolean add(E e){
        boolean added = super.add(e);
        if(added) notifyElementAdded(e);
        return added;
    }

    @Override public boolean addAll(Collection<? extends E> c){
        boolean res = false;
        for(E e: c) res |= add(e);
        return res;
    }
}
