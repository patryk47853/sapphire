package com.patrykjava.sapphire.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.patrykjava.sapphire.domain.Order;
import com.patrykjava.sapphire.repository.OrderRepository;

import java.time.Instant;
import java.util.List;

@Service
public class OrderService {

    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Transactional
    public Order createOrder(Order order) {
        order.setCreatedAt(Instant.now());
        return orderRepository.save(order);
    }

    public List<Order> findAllOrders() {
        return orderRepository.findAll();
    }

    public Order findOrderById(String id) {
        return orderRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Order not found: " + id));
    }
}

