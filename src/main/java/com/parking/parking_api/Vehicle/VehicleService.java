package com.parking.parking_api.Vehicle;

import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;
import java.util.List;

@Service
@RequiredArgsConstructor
public class VehicleService {

    private final VehicleRepository vehicleRepo;

    // Create method
    public Vehicle createVehicle(Vehicle vehicle) {
        return vehicleRepo.save(vehicle);
    }

    // Get method
    public List<Vehicle> getVehicles() {
        return vehicleRepo.findAll();
    }
}
