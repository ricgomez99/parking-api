package com.parking.parking_api.Owner;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "owners")
public class Owner {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "own_id")
    private String ownerId;

    @Basic
    @NotBlank(message = "Owner's name is required")
    private String firstName;
    @NotBlank(message = "Owner's last name is required")
    private String lastName;
}
