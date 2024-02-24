package com.parking.parking_api.Vehicle;

import com.parking.parking_api.Owner.Owner;

import jakarta.persistence.Basic;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "vehicles")
public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "vehicle_id")
    private String vehicleId;

    @Basic
    @NotBlank(message = "CarPlate is required")
    @Size(min = 3, max = 7)
    private String carPlate;

    @NotBlank(message = "Color is required")
    private String color;

    @Positive(message = "Number of Doors must be a positive number")
    @Min(3)
    @Max(6)
    private int doors;

    @NotBlank(message = "Model is required")
    private String model;
    private String registrationDate;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_own_id")
    private Owner owner;
}
