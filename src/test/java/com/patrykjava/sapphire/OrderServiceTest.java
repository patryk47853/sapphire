package com.patrykjava.sapphire;

import com.patrykjava.sapphire.domain.Order;
import com.patrykjava.sapphire.domain.OrderItem;
import com.patrykjava.sapphire.repository.OrderRepository;
import com.patrykjava.sapphire.service.OrderService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class OrderServiceTest {

    private OrderRepository orderRepository;
    private OrderService orderService;

    @BeforeEach
    void setUp() {
        orderRepository = mock(OrderRepository.class);
        orderService = new OrderService(orderRepository);
    }

    @Test
    void shouldSaveValidOrder() {
        Order order = new Order();
        OrderItem item = new OrderItem();
        item.setPriceAtPurchase(BigDecimal.valueOf(50));
        item.setQuantity(2);
        order.setItems(List.of(item));
        order.setTotalAmount(BigDecimal.valueOf(100));

        when(orderRepository.save(order)).thenReturn(order);

        Order saved = orderService.createOrder(order);
        assertNotNull(saved);
        verify(orderRepository, times(1)).save(order);
    }
}
