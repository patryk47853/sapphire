package com.patrykjava.sapphire.repository;

import com.patrykjava.sapphire.domain.KafkaEventLog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KafkaEventLogRepository extends JpaRepository<KafkaEventLog, Long> {
}
