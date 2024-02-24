package com.parking.parking_api.Vehicle;

import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.List;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequiredArgsConstructor
public class VehicleController {

    private final VehicleService vehicleService;

    @GetMapping("/vehicles")
    public List<Vehicle> getVehicles() {
        return vehicleService.getVehicles();
    }

    @PostMapping("/vehicles")
    public void createVehicle(@Valid @RequestBody Vehicle vehicle) {
        vehicleService.createVehicle(vehicle);
    }

}
