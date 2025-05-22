package com.LojaVeiculos.AluguelVeiculos.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "Cadastro_Veiculos")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class VehicleModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long vehicleId;
    private String model;
    private String brand;
    private String color;
    private double price;

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn (name = "Car-Rental_id")
    private CarRentalModel carRental;
}
