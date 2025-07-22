package com.example.Food_Delivery_Management.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "drivers")
public class DriverEntity {

    @Id
    private String id;

    private String name;
    private String status; // Avilable or Busy
    private String currentOrderId;
    private int nextAvilableAt;


    public DriverEntity() {}

    public DriverEntity(String name) {
        this.name = name;
        this.status = "AVILABLE";//----->Status is avilable by default
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCurrentOrderId() {
        return currentOrderId;
    }

    public void setCurrentOrderId(String currentOrderId) {
        this.currentOrderId = currentOrderId;
    }
    public int getNextAvilableAt() {
        return nextAvilableAt;
    }
    public void setNextAvailableAt(int nextAvilableAt) {
        this.nextAvilableAt = nextAvilableAt;
    }
}
