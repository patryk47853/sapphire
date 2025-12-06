package com.patrykjava.sapphire.kafka.consumer;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.patrykjava.sapphire.kafka.event.OrderCreatedEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class OrderEventConsumer {

    private final ObjectMapper objectMapper = new ObjectMapper();

    @KafkaListener(topics = "order-created", groupId = "sapphire-group")
    public void consume(String message) {
        try {
            OrderCreatedEvent event = objectMapper.readValue(message, OrderCreatedEvent.class);
            log.info("📥 Received OrderCreatedEvent: {}", event);
        } catch (Exception e) {
            log.error("Failed to process Kafka message", e);
        }
    }
}
