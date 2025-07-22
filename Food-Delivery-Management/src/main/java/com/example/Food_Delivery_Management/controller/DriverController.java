package com.example.Food_Delivery_Management.controller;

import com.example.Food_Delivery_Management.entity.DriverEntity;
import com.example.Food_Delivery_Management.services.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/drivers")
public class DriverController {

    @Autowired
    private DriverService driverService;

    @GetMapping("/all")
    public List<DriverEntity> getAllDrivers() {
        return driverService.getAllDrivers();//----> get all drivers
    }


    @GetMapping("/{id}")
    public DriverEntity getDriverById(@PathVariable String id) {
        return driverService.getDriverById(id).orElse(null);
    }//---->get driver by id


    @PostMapping("/add")
    public DriverEntity addDriver(@RequestBody DriverEntity driver) {
        return driverService.addDriver(driver);//----> add driver
    }

    @PutMapping("/update/{id}")
    public String updateDriverStatus(@PathVariable String id,
                                     @RequestParam String status,
                                     @RequestParam int nextAvailableAt) {
        boolean success = driverService.updateDriverStatus(id, status, nextAvailableAt);
        return success ? "Updated successfully" : "Driver not found";
    }//----. update driver status and avilability
}
