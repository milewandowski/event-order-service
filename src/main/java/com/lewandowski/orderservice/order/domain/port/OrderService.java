package com.lewandowski.orderservice.order.domain.port;

import com.lewandowski.orderservice.order.domain.model.Order;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public final class OrderService {

    private final OrderRepository orderRepository;
    private final OrderPublisher orderPublisher;

    public Order get(String id) {
        return orderRepository.findById(id).orElseThrow();
    }

    public List<Order> getAll() {
        return orderRepository.findAll();
    }

    public Order create(Order order) {
        Order savedOrder = orderRepository.save(order);
        orderPublisher.send(savedOrder);

        return savedOrder;
    }

    public void update(Order order) {
        orderRepository.save(order);
    }
}
