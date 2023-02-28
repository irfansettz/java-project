package com.ikon.orderservice.service.impl;

import com.ikon.orderservice.entity.Order;
import com.ikon.orderservice.repository.OrderRepository;
import com.ikon.orderservice.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;

    @Override
    public List<Order> getALlOrderByUserId(Long userid) {
        List<Order> allOrder = orderRepository.findByUserid(userid);
        return allOrder;
    }

    @Override
    public List<Order> getOrderById(Long id) {
        List<Order> order = new ArrayList<>();
        order.add(orderRepository.findById(id).get());
        return order;
    }

    @Override
    public List<Order> createOrder(Order order) {
        List<Order> orderSave = new ArrayList<>();
        orderSave.add(orderRepository.save(order));
        return orderSave;
    }

    @Override
    public List<Order> updateFinishOrderById(Order order, Long id) {
        Order updated = orderRepository.findById(id).get();
        updated.setFinished(order.getFinished());

        List<Order> updatedOrder = new ArrayList<>();
        updatedOrder.add(orderRepository.save(updated));
        return updatedOrder;
    }
}
