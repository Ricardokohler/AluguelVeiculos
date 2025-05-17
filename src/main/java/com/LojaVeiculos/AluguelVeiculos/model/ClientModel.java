package com.LojaVeiculos.AluguelVeiculos.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Cadastro_Cliente")
@AllArgsConstructor
@NoArgsConstructor
@Data

public class ClientModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String name;
    private String email;
    private String address;

    @OneToOne
    VehicleModel vehicle;
}
