package com.patrykjava.sapphire.dto;

import com.patrykjava.sapphire.domain.OrderStatus;
import com.patrykjava.sapphire.domain.PaymentMethod;
import com.patrykjava.sapphire.domain.PaymentStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderDto {
    private Long id;
    private BigDecimal totalAmount;
    private Instant createdAt;
    private OrderStatus status;
    private PaymentMethod paymentMethod;
    private PaymentStatus paymentStatus;
    private List<OrderItemDto> items;
}
