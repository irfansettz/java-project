package com.ikon.orderservice.dto;

import com.ikon.orderservice.entity.Order;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class OrderDTO extends ResponseDTO{
    private List<Order> data;
}
