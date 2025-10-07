package com.nrz.efj.chapter10.item79;

import com.nrz.efj.chapter03.item18.ForwardingSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 어떤 Set을 감싼 래퍼클래스이다. 클라이언트는 Set에 add될때 알림을 받을 수 있다.
 *  -> 관찰자 패턴 (제거 될 떄 알려주는 기능 생략)
 *
 */
public class ObservableSet<E> extends ForwardingSet<E> {

    public ObservableSet(Set<E> s) {
        super(s);
    }

    private final List<SetObserver<E>> observers = new ArrayList<>();
    public void addObserver(SetObserver<E> observer){
        synchronized (observers){
            observers.add(observer);
        }
    }

    public boolean removeObserver(SetObserver<E> observer){
        synchronized (observers){
            return observers.remove(observer);
        }
    }

//    private void notifyElementAdded(E e){
//        synchronized (observers){
//            for(SetObserver<E> observer: observers){
//                observer.added(this, e);
//            }
//        }
//    }

    // 두 예제에서 발생하는 데드락 해결
    private void notifyElementAdded(E e){
        List<SetObserver<E>> snapshot = null;
        synchronized (observers){
            snapshot = new ArrayList<>(observers);
        }

        for(SetObserver<E> observer: snapshot){
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

    public static void main(String[] args) {
        ObservableSet<Integer> set = new ObservableSet<>(new HashSet<>());
        set.addObserver((s, e) -> System.out.println(e));

        for(int i = 0; i < 100 ; i++) set.add(i);
    }
}
