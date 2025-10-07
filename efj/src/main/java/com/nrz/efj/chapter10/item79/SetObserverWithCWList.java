package com.nrz.efj.chapter10.item79;

@FunctionalInterface public interface SetObserverWithCWList<E> {
    void added(ObservableSetWithCWList<E> set, E e);
}
