package com.lewandowski.orderservice.order.adapter.publisher;

import com.lewandowski.orderservice.order.domain.model.Order;
import com.lewandowski.orderservice.order.domain.port.OrderPublisher;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
class MessageBrokerOrderPublisher implements OrderPublisher {

    private final KafkaTemplate<String, Order> kafkaTemplate;

    @Override
    public void send(Order order) {
        log.info("Sending order with id: {}", order.getId());
        kafkaTemplate.send("order_payment", order);
    }
}
