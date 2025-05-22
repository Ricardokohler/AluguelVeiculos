package com.LojaVeiculos.AluguelVeiculos.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
@Entity
@Table(name = "Cadastro_Aluguel")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CarRentalModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long carRentalId;
    private LocalDateTime start;
    private LocalDateTime finish;

    @OneToOne (cascade = CascadeType.ALL)
    @JoinColumn (name = "vehicle_id")
    private VehicleModel vehicle;

    @OneToOne (cascade = CascadeType.ALL)
    @JoinColumn (name = "Invoice_id")
    private InvoiceModel invoice;

    @OneToOne (cascade = CascadeType.ALL)
    @JoinColumn (name = "Client_id")
    private ClientModel client;


}
