package com.LojaVeiculos.AluguelVeiculos.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Cadastro_Fatura")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class InvoiceModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long invoiceId;
    private double basicPayment;
    private double tax = 1;

    @OneToOne (cascade = CascadeType.PERSIST)
    @JoinColumn (name = "Car-Rental_id")
    private CarRentalModel carRental;

    private double totalPayment(){
        return getBasicPayment() * tax;
    }
}
