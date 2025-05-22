package com.LojaVeiculos.AluguelVeiculos.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Cadastro_Clientes")
@AllArgsConstructor
@NoArgsConstructor
@Data

public class ClientModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long clientId;
    private String name;
    private String email;
    private String address;

    @OneToOne (cascade = CascadeType.PERSIST)
    @JoinColumn (name = "Car-Rental_id")
    private CarRentalModel carRental;
}
