package com.nrz.efj.chapter10.item79;

/**
 * BiConsumer와 같아서 그거 써도 됨.
 */
@FunctionalInterface public interface SetObserver<E> {
    // ObservableSet에 원소 추가시 호출
    void added(ObservableSet<E> set, E e);
}
