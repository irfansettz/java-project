package com.ikon.orderservice.controller;

import com.ikon.orderservice.dto.OrderDTO;
import com.ikon.orderservice.entity.Order;
import com.ikon.orderservice.exception.BaseError;
import com.ikon.orderservice.exception.ProductNotFound;
import com.ikon.orderservice.repository.OrderRepository;
import com.ikon.orderservice.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

@RestController
@RequestMapping("v1/api/orders")
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService;
    private final OrderRepository orderRepository;

    @GetMapping
    public ResponseEntity<OrderDTO> getAllOrderUser(@RequestParam("userid") Long userid){
        List<Order> allOrderByUserId = orderService.getALlOrderByUserId(userid);

        OrderDTO response = new OrderDTO();
        response.setCode(200);
        response.setStatus("success");
        response.setData(allOrderByUserId);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderDTO> getOrderById(@PathVariable Long id){
        if (orderRepository.findById(id).isEmpty()) throw new ProductNotFound("Product Not Found");
        List<Order> orderById = orderService.getOrderById(id);

        OrderDTO response = new OrderDTO();
        response.setCode(200);
        response.setStatus("success");
        response.setData(orderById);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<OrderDTO> createOrder(@RequestBody Order order) throws IOException {
        URL url = new URL("http://localhost:8060/v1/api/products/" + order.getProductid());
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");
        int status = con.getResponseCode();
        con.disconnect();
        if (status >= 500) throw new BaseError();
        if (status == 404 ) throw new ProductNotFound("Product Not Found");

        List<Order> saveOrder = orderService.createOrder(order);

        OrderDTO response = new OrderDTO();
        response.setCode(201);
        response.setStatus("created");
        response.setData(saveOrder);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<OrderDTO> updateFinishOrderById(@RequestBody Order order, @PathVariable Long id){
        if (orderRepository.findById(id).isEmpty()) throw new ProductNotFound("Product Not Found");
        List<Order> updateFinishOrder = orderService.updateFinishOrderById(order, id);

        OrderDTO response = new OrderDTO();
        response.setCode(201);
        response.setStatus("updated");
        response.setData(updateFinishOrder);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

}
