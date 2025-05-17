package com.LojaVeiculos.AluguelVeiculos.controller;

import com.LojaVeiculos.AluguelVeiculos.model.VehicleModel;
import com.LojaVeiculos.AluguelVeiculos.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/vehicle")
public class VehicleController {

    @Autowired
    private VehicleService service;

    @PostMapping
    public VehicleModel createVehicle(@RequestBody VehicleModel vehicle){
       return service.createVehicle(vehicle);
    }

    @GetMapping("/all")
    public List <VehicleModel> getAllVehicles(){
        return service.getAllVehicles();
    }

    @GetMapping("/{id}")
    public Optional <VehicleModel> getVehicleById(@PathVariable Long id){
        return service.getVehicleById(id);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteVehicleById(@PathVariable Long id){
        service.deleteVehicleById(id);
    }

    //faltando update
    //usar put
}
