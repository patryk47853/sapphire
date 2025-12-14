package com.patrykjava.sapphire.domain;

import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "kafka_event_log")
public class KafkaEventLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String topic;

    @Column(nullable = false)
    private String eventType;

    @Column(nullable = false, length = 2000)
    private String payload;

    @Column(nullable = false)
    private Instant receivedAt;
}
