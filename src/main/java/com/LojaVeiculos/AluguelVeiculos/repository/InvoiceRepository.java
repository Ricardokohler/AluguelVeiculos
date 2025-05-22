package com.LojaVeiculos.AluguelVeiculos.repository;

import com.LojaVeiculos.AluguelVeiculos.model.InvoiceModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvoiceRepository extends JpaRepository<InvoiceModel, Long> {
}
