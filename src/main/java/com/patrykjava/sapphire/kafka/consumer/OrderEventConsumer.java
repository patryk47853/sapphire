package com.patrykjava.sapphire.kafka.consumer;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.patrykjava.sapphire.domain.KafkaEventLog;
import com.patrykjava.sapphire.kafka.event.OrderCreatedEvent;
import com.patrykjava.sapphire.repository.KafkaEventLogRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.time.Instant;

@Slf4j
@Component
@RequiredArgsConstructor
public class OrderEventConsumer {

    private final KafkaEventLogRepository kafkaEventLogRepository;
    private final ObjectMapper objectMapper = new ObjectMapper();

    @KafkaListener(topics = "order-created", groupId = "sapphire-group")
    public void consume(String message) {
        try {
            OrderCreatedEvent event =
                    objectMapper.readValue(message, OrderCreatedEvent.class);

            log.info("📥 Received OrderCreatedEvent: {}", event);

            kafkaEventLogRepository.save(
                    KafkaEventLog.builder()
                            .topic("order-created")
                            .eventType("OrderCreatedEvent")
                            .payload(message)
                            .receivedAt(Instant.now())
                            .build()
            );

        } catch (Exception e) {
            log.error("Failed to process Kafka message", e);
            throw new RuntimeException(e);
        }
    }
}
