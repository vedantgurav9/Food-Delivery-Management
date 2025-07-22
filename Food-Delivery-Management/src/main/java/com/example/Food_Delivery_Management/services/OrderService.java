package com.example.Food_Delivery_Management.services;

import com.example.Food_Delivery_Management.entity.DriverEntity;
import com.example.Food_Delivery_Management.entity.OrderEntity;
import com.example.Food_Delivery_Management.repository.DriverRepo;
import com.example.Food_Delivery_Management.repository.OrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepo orderRepo;

    @Autowired
    private DriverRepo driverRepo;

    public String placeOrder(OrderEntity order) {

        List<DriverEntity> drivers = driverRepo.findAll();
        DriverEntity selectedDriver = null;//---->// Get all drivers sorted by id: lowest id first


        for (DriverEntity driver : drivers) {
            if (driver.getNextAvilableAt() <= order.getOrderTime()) {
                selectedDriver = driver;
                break;//---->// Find the first driver whose nextAvilableAt <= order.orderTime
            }
        }

        if (selectedDriver != null) {
            order.setAssignedDriverId(selectedDriver.getId());
            order.setStatus("BUSY");
            orderRepo.save(order);//assign driver

            selectedDriver.setStatus("BUSY");
            selectedDriver.setCurrentOrderId(order.getId());
            int newNextAvailable = order.getOrderTime() + order.getTravelTime();
            selectedDriver.setNextAvailableAt(newNextAvailable);
            driverRepo.save(selectedDriver);

            return selectedDriver.getId();
        } else {
            order.setStatus("No Food :-(");
            orderRepo.save(order);
            return "No Food :-(";
        }
    }

    public java.util.Optional<OrderEntity> getOrderById(String orderId) {
        return orderRepo.findById(orderId);//---->get order by id
    }
    public List<OrderEntity> getAllOrders() {
        return orderRepo.findAll();
    }//----get all orders


}
