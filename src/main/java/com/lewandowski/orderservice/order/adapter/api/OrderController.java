package com.lewandowski.orderservice.order.adapter.api;

import com.lewandowski.orderservice.order.domain.model.Order;
import com.lewandowski.orderservice.order.domain.port.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
@RequiredArgsConstructor
class OrderController {

    private final OrderService orderService;

    @GetMapping("/{id}")
    Order get(@PathVariable String id) {
        return orderService.get(id);
    }

    @GetMapping
    List<Order> getAll() {
        return orderService.getAll();
    }

    @PostMapping
    Order create(@RequestBody final Order order) {
        return orderService.create(order);
    }

    //    @GetMapping("/add")
    //    Order create() {
    //        return orderService.create(new Order());
    //    }
}
