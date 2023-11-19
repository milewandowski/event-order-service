package com.lewandowski.orderservice.order.domain.port;

import com.lewandowski.orderservice.order.domain.model.Order;

public interface OrderPublisher {

    void send(Order order);
}
