package com.LojaVeiculos.AluguelVeiculos.repository;

import com.LojaVeiculos.AluguelVeiculos.model.CarRentalModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRentalRepository extends JpaRepository<CarRentalModel, Long> {

}
