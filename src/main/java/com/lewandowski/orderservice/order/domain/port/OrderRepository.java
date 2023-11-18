package com.lewandowski.orderservice.order.domain.port;

import com.lewandowski.orderservice.order.domain.model.Order;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface OrderRepository extends MongoRepository<Order, String> {
}
