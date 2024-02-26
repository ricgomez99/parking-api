package com.parking.parking_api.Vehicle;

import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequiredArgsConstructor
public class VehicleController {

    private final VehicleService vehicleService;

    @GetMapping("/vehicles")
    public List<Vehicle> getVehicles() {
        return vehicleService.getVehicles();
    }

    @GetMapping("/vehicles/{id}")
    public Vehicle getVehicleById(@PathVariable String id) {
        return vehicleService.getVehicleById(id);
    }

    @PostMapping("/vehicles")
    public void createVehicle(@Valid @RequestBody Vehicle vehicle) {
        vehicleService.createVehicle(vehicle);
    }

    @PutMapping("/vehicles/{id}")
    public void updateVehicle(@PathVariable String id, @RequestBody Map<String, Object> properties) {
        vehicleService.updateVehicle(id, properties);
    }

    @DeleteMapping("/vehicles/{id}")
    public void deleteVehicle(@PathVariable String id) {
        vehicleService.deleteVehicle(id);
    }

}
