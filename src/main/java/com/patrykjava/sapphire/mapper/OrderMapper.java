package com.patrykjava.sapphire.mapper;

import com.patrykjava.sapphire.dto.OrderDto;
import com.patrykjava.sapphire.dto.OrderItemDto;
import com.patrykjava.sapphire.domain.Order;
import com.patrykjava.sapphire.domain.OrderItem;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class OrderMapper {

    public OrderDto toDto(Order order) {
        OrderDto dto = new OrderDto();
        dto.setId(order.getId());
        dto.setTotalAmount(order.getTotalAmount());
        dto.setCreatedAt(order.getCreatedAt());
        dto.setStatus(order.getStatus());
        dto.setPaymentMethod(order.getPaymentMethod());
        dto.setPaymentStatus(order.getPaymentStatus());
        dto.setItems(order.getItems().stream()
                .map(this::toItemDto)
                .collect(Collectors.toList()));
        return dto;
    }

    private OrderItemDto toItemDto(OrderItem item) {
        return new OrderItemDto(
                item.getProduct().getId(),
                item.getQuantity(),
                item.getPriceAtPurchase()
        );
    }
}
