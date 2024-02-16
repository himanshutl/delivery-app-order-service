package com.deliveryapp.orderservice.controller;

import com.deliveryapp.orderservice.dto.OrderRequest;
import com.deliveryapp.orderservice.dto.OrderResponse;
import com.deliveryapp.orderservice.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order")
@CrossOrigin(origins = "*")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("/saveOrder")
    public ResponseEntity<OrderResponse> saveOrder(@RequestBody OrderRequest orderRequest) {
        OrderResponse orderSavedInDb =  orderService.saveOrderInDb(orderRequest);
        return new ResponseEntity<>(orderSavedInDb, HttpStatus.CREATED);
    }
}
