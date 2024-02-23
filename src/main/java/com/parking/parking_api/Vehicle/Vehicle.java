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
    private String color;
    private String model;
    private String carPlate;
    private int doors;
    private String registrationDate;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_own_id")
    private Owner owner;
}
