package com.lewandowski.orderservice.order.adapter.consumer;

import com.lewandowski.orderservice.order.domain.model.Order;
import com.lewandowski.orderservice.order.domain.port.OrderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
class MessageBrokerStatusConsumer {

    private final OrderService orderService;

    @KafkaListener(topics = "order-status-local2", groupId = "order-service")
    void consume(@Payload Order order) {
        log.info("Order event received: {}", order);
        orderService.update(order);
    }
}
