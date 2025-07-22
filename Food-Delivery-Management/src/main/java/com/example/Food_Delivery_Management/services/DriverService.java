package com.example.Food_Delivery_Management.services;

import com.example.Food_Delivery_Management.entity.DriverEntity;
import com.example.Food_Delivery_Management.repository.DriverRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DriverService {

    @Autowired
    private DriverRepo driverRepo;


    public DriverEntity addDriver(DriverEntity driver) {
        driver.setStatus("AVILABLE");
        driver.setNextAvailableAt(0);
        return driverRepo.save(driver);//---->// add a new driver, status set to AVILABLE and nextAvilableAt = 0 by default
    }

    public List<DriverEntity> getAllDrivers() {
        return driverRepo.findAll();//----> get all drivers
    }


    public Optional<DriverEntity> getDriverById(String driverId) {
        return driverRepo.findById(driverId);//---->get driver by id
    }

    public boolean updateDriverStatus(String driverId, String status, int nextAvailable) {
        Optional<DriverEntity> optDriver = driverRepo.findById(driverId);
        if (optDriver.isPresent()) {
            DriverEntity driver = optDriver.get();
            driver.setStatus(status);
            driver.setNextAvailableAt(nextAvailable);
            driverRepo.save(driver);
            return true;//----> update driver status and next avilable time
        }
        return false;
    }
}
