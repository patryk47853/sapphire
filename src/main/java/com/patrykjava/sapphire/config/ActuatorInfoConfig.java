package com.patrykjava.sapphire.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.boot.actuate.info.InfoContributor;

import java.util.Map;

@Configuration
public class ActuatorInfoConfig {

    @Bean
    public InfoContributor appInfoContributor() {
        return info -> info.withDetail(
                "application",
                Map.of(
                        "name", "Sapphire Backend",
                        "java", "21",
                        "stack", "Spring Boot, Kafka, PostgreSQL"
                )
        );
    }
}
