package com.patrykjava.sapphire.kafka.service;

import com.patrykjava.sapphire.kafka.event.OrderCreatedEvent;
import com.patrykjava.sapphire.kafka.producer.OrderEventProducer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderEventService {

    private final OrderEventProducer producer;

    public void publishOrderEvent(Long orderId, Long userId, Double price) {
        OrderCreatedEvent event = new OrderCreatedEvent(orderId, userId, price);
        producer.sendOrderCreatedEvent(event);
    }
}
