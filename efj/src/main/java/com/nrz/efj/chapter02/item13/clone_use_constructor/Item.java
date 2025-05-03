package com.nrz.efj.chapter02.item13.clone_use_constructor;

public class Item implements Cloneable {

    private String name;

    /**
     * 이렇게 구현하면 하위 클래스의 clone()이 깨질 수 있다. p78
     * ClassCastException 이 발생함 -> super.clone()을 호출해야함
     * @return
     */
    @Override
    public Item clone() {
        Item item = new Item();
        item.name = this.name;
        return item;
    }
}
