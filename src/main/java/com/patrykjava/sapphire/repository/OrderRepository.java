package com.patrykjava.sapphire.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.patrykjava.sapphire.domain.Order;

public interface OrderRepository extends JpaRepository<Order, String> {
}

