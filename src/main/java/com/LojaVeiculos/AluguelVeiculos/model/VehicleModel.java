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
    private String modelVehicle;
    private String brand;
    private String color;
    private String engine;

    @OneToOne
    ClientModel client;


}
