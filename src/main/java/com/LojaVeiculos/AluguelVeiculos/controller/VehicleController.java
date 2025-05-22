package com.LojaVeiculos.AluguelVeiculos.controller;

import com.LojaVeiculos.AluguelVeiculos.model.VehicleModel;
import com.LojaVeiculos.AluguelVeiculos.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/vehicle")
public class VehicleController {

    @Autowired
    private VehicleService service;

    //METODO POST
    //LINK: https://localhost:8080/vehicle/add
    @PostMapping("/add")
    public ResponseEntity<VehicleModel> createVehicle(@RequestBody VehicleModel vehicle){
        VehicleModel newVehicle = service.createVehicle(vehicle);
        return new ResponseEntity<>(newVehicle, HttpStatus.CREATED);
    }

    //METODO GET ALL
    //LINK: http://localhost:8080/vehicle/all
    @GetMapping("/all")
    public ResponseEntity <List <VehicleModel>> getAllVehicles(){
       List <VehicleModel> allVehicles = service.getAllVehicles();
        return new ResponseEntity<>(allVehicles, HttpStatus.OK);
    }

    //METODO GET BY ID
    //LINK: https://localhost:8080/vehicle/{id}
    @GetMapping("/{id}")
    public  ResponseEntity <?> getVehicleById(@PathVariable Long id){
        Optional <VehicleModel> optionalVehicle = service.getVehicleById(id);

        if (optionalVehicle.isPresent()){
            return ResponseEntity.ok(optionalVehicle.get());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("id não encontrado");
        }
    }

    //METODO DELETE
    //LINK: https://localhost:8080/vehicle/delete/{id}
    @DeleteMapping("/delete/{id}")
    public void deleteVehicleById(@PathVariable Long id){
        service.deleteVehicleById(id);
    }

    //METODO UPDATE
    //LINK: https://localhost:8080/vehicle/update/{id}
    @PutMapping("/update/{id}")
    public ResponseEntity <VehicleModel> updateVehicle(@PathVariable Long id, @RequestBody VehicleModel vehicle){

        try{
            VehicleModel vehicleUpdate = service.updateVehicle(vehicle, id);
            return new ResponseEntity<>(vehicleUpdate, HttpStatus.CREATED);
        } catch (RuntimeException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

}
