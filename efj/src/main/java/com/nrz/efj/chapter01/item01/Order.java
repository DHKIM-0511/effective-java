package com.nrz.efj.chapter01.item01;

public class Order {
    private boolean prime;

    private boolean urgent;

    private Product product;

    private OrderStatus orderStatus;

    //여러 생성자를 만들때, 파라미터 타입이 겹치면 정적팩토리를 고려할 수 있다
    public static Order primeOrder(Product product) {
        Order order = new Order();
        order.prime = true;
        order.product = product;

        return order;
    }

    public static Order urgentOrder(Product product) {
        Order order = new Order();
        order.urgent = true;
        order.product = product;
        return order;
    }
}
