package com.parking.parking_api;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.Map;
import java.util.HashMap;

public class JSONUtils {

    private static String carPlate;
    private static String color;
    private static int doors;
    private static String model;
    private static String registrationDate;
    private static String firstName;
    private static String lastName;

    private static final ObjectMapper objectMapper = new ObjectMapper();

    public JSONUtils(String carPlate, String color, int doors,
            String model,
            String registrationDate,
            String firstName,
            String lastName) {

        JSONUtils.carPlate = carPlate;
        JSONUtils.color = color;
        JSONUtils.doors = doors;
        JSONUtils.model = model;
        JSONUtils.registrationDate = registrationDate;
        JSONUtils.firstName = firstName;
        JSONUtils.lastName = lastName;
    }

    public String buildVehicleJson() throws Exception {
        Map<String, Object> vehicleData = new HashMap<>();
        vehicleData.put("carPlate", carPlate);
        vehicleData.put("color", color);
        vehicleData.put("doors", doors);
        vehicleData.put("model", model);
        vehicleData.put("registrationDate", registrationDate);

        Map<String, Object> ownerData = new HashMap<>();
        ownerData.put("firstName", firstName);
        ownerData.put("lastName", lastName);

        vehicleData.put("owner", ownerData);

        return objectMapper.writeValueAsString(vehicleData);

    }

}
