package com.parking.parking_api.Vehicle;

import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;

import lombok.RequiredArgsConstructor;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class VehicleService {

    private final VehicleRepository vehicleRepo;

    // Create method
    public Vehicle createVehicle(Vehicle vehicle) {
        return vehicleRepo.save(vehicle);
    }

    // Get All method
    public List<Vehicle> getVehicles() {
        return vehicleRepo.findAll();
    }

    // Get By Id
    public Vehicle getVehicleById(String id) {
        return vehicleRepo.findById(id).orElse(null);
    }

    // Delete Vehicle
    public void deleteVehicle(String id) {
        vehicleRepo.deleteById(id);
    }

    // Update Vehicle
    public void updateVehicle(String id, Map<String, Object> properties) {
        Vehicle currentVehicle = vehicleRepo.findById(id).get();
        properties.forEach((key, value) -> {
            Field field = ReflectionUtils.findField(Vehicle.class, key);
            field.setAccessible(true);
            ReflectionUtils.setField(field, currentVehicle, value);
        });

        vehicleRepo.save(currentVehicle);
    }

}
