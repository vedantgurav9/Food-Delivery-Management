package com.example.Food_Delivery_Management.repository;

import com.example.Food_Delivery_Management.entity.DriverEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface DriverRepo extends MongoRepository<DriverEntity, String> {

}
