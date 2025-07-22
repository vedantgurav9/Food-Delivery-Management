package com.example.Food_Delivery_Management.controller;

import com.example.Food_Delivery_Management.entity.OrderEntity;
import com.example.Food_Delivery_Management.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("/place")
    public String placeOrder(@RequestBody OrderEntity order) {
        return orderService.placeOrder(order);//-----> place a new order
    }


    @GetMapping("/{id}")
    public OrderEntity getOrder(@PathVariable String id) {
        return orderService.getOrderById(id).orElse(null);//----->get order details
    }
    @GetMapping("/all")
    public List<OrderEntity> getAllOrders() {
        return orderService.getAllOrders();
    }//----> get all orde
}
