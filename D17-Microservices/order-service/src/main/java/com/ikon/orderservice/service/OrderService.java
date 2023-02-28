package com.ikon.orderservice.service;

import com.ikon.orderservice.entity.Order;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface OrderService {
    List<Order> getALlOrderByUserId(Long userid);

    List<Order> getOrderById(Long id);

    List<Order> createOrder(Order order);

    List<Order> updateFinishOrderById(Order order, Long id);
}
