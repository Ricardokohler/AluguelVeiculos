package com.LojaVeiculos.AluguelVeiculos.repository;

import com.LojaVeiculos.AluguelVeiculos.model.VehicleModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehicleRepository extends JpaRepository<VehicleModel, Long> {
}
