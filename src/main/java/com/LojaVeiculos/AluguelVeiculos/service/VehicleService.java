package com.LojaVeiculos.AluguelVeiculos.service;

import com.LojaVeiculos.AluguelVeiculos.model.VehicleModel;
import com.LojaVeiculos.AluguelVeiculos.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VehicleService {

    @Autowired
    private VehicleRepository repository;

    //Create
    public VehicleModel createVehicle(VehicleModel vehicle) {
        return repository.save(vehicle);
    }

    //GetAll
    public List<VehicleModel> getAllVehicles() {
        return repository.findAll();
    }

    //GetById
    public Optional<VehicleModel> getVehicleById(Long id) {
        return repository.findById(id);
    }

    //Delete
    public void deleteVehicleById(Long id) {
        repository.deleteById(id);
    }

    //Update
    public VehicleModel updateVehicle(VehicleModel vehicle, Long id) {
        Optional<VehicleModel> oldVehicle = repository.findById(id);

        if(oldVehicle.isPresent()){
            VehicleModel newVehicle = oldVehicle.get();

            newVehicle.setBrand(vehicle.getBrand());
            newVehicle.setColor(vehicle.getColor());
            newVehicle.setModel(vehicle.getModel());
            newVehicle.setPrice(vehicle.getPrice());

            return repository.save(newVehicle);
        } else {
            throw new RuntimeException("Id não encontrado");
        }
    }
}