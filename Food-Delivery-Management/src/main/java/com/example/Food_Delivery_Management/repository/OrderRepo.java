package com.example.Food_Delivery_Management.repository;

import com.example.Food_Delivery_Management.entity.OrderEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface OrderRepo extends MongoRepository<OrderEntity, String> {

}
