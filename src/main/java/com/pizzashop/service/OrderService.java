package com.pizzashop.service;

import org.springframework.stereotype.Service;

import com.pizzashop.model.Order;
import com.pizzashop.repository.OrderRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class OrderService {
    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public Mono<Order> placeOrder(Order order) {
        return orderRepository.save(order);
    }

    public Flux<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    public Mono<Order> getOrderById(String id) {
        return orderRepository.findById(id)
                .switchIfEmpty(Mono.error(new RuntimeException("Order not found!")));
    }

    public Mono<Order> updateOrderStatus(String id, String status) {
        return orderRepository.findById(id)
                .flatMap(order -> {
                    order.setStatus(status);
                    return orderRepository.save(order);
                })
                .switchIfEmpty(Mono.error(new RuntimeException("Order not found!")));
    }

    public Mono<Void> cancelOrder(String id) {
        return orderRepository.deleteById(id);
    }
}
