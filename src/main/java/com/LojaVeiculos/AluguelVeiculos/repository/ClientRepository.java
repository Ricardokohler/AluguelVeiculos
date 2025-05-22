package com.LojaVeiculos.AluguelVeiculos.repository;

import com.LojaVeiculos.AluguelVeiculos.model.ClientModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<ClientModel, Long> {

}

