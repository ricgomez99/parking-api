package com.parking.parking_api;

import java.nio.charset.Charset;

import org.springframework.http.MediaType;
import org.hamcrest.core.Is;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.parking.parking_api.Vehicle.VehicleController;
import com.parking.parking_api.Vehicle.VehicleRepository;
import com.parking.parking_api.Vehicle.VehicleService;

@RunWith(SpringRunner.class)
@WebMvcTest
@AutoConfigureMockMvc
public class VehicleControllerIntegrationTest {

    @MockBean
    private VehicleRepository vehicleRepo;

    @MockBean
    private VehicleService vehicleService;

    @Autowired
    VehicleController vehicleController;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void postValidVehicle_thenCorrectResponse() throws Exception {
        JSONUtils vehicle = new JSONUtils("DDT-890", "red", 5, "Ford Fiesta", "26/02/2024", "Camila", "Gomez");
        mockMvc.perform(MockMvcRequestBuilders.post("/vehicles")
                .content(vehicle.buildVehicleJson())
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void postInvalidVehicle_thenCorrectResponse() throws Exception {
        JSONUtils vehicle = new JSONUtils("UTF-3344", "blue", 8, "Karin", "23/02/2024", "Ramon", "Perez");
        mockMvc.perform(MockMvcRequestBuilders.post("/vehicles")
                .content(vehicle.buildVehicleJson())
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isBadRequest())
                .andExpect(MockMvcResultMatchers.jsonPath("$.carPlate", Is.is("CarPlate is required")))
                .andExpect(MockMvcResultMatchers.jsonPath("$.doors", Is.is("Doors must be a number between 3-6")))
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON_VALUE));
    }

}
