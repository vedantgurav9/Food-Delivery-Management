package com.example.Food_Delivery_Management.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.LocalDateTime;

@Document(collection = "orders")
public class OrderEntity {

    @Id
    private String id;

    private int orderTime;// time at whoch order is placed

    private int travelTime;//time required to deliver the order


    private String assignedDriverId;//order id of assigned driver

    private String status;//--->Pending, busy, delivered


    public OrderEntity() {}

    public OrderEntity(int orderTime, int travelTime) {
        this.orderTime = orderTime;
        this.travelTime = travelTime;
        this.status = "PENDING";//----->order status is pending by default
    }

    public String getId() {
        return id;
    }

    public int getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(int orderTime) {
        this.orderTime = orderTime;
    }

    public int getTravelTime() {
        return travelTime;
    }

    public void setTravelTime(int travelTime) {
        this.travelTime = travelTime;
    }

    public String getAssignedDriverId() {
        return assignedDriverId;
    }

    public void setAssignedDriverId(String assignedDriverId) {
        this.assignedDriverId = assignedDriverId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
