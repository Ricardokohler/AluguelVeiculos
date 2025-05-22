package com.LojaVeiculos.AluguelVeiculos.controller;


import com.LojaVeiculos.AluguelVeiculos.model.CarRentalModel;
import com.LojaVeiculos.AluguelVeiculos.service.CarRentalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/carrental")
public class CarRentalController {

    @Autowired

    private CarRentalService service;

    //METODO CREATE
    //LINK: https://localhost/8080/carrental/add
    @PostMapping("/add")
    public ResponseEntity <CarRentalModel> createCarRental(@RequestBody CarRentalModel carRental){
        CarRentalModel newCarRental = service.processInvoice(carRental);

        return new ResponseEntity<>(newCarRental, HttpStatus.CREATED);
    }

    //METODO GET ALL
    //LINK: https://localhost/8080/carrental/all
    @GetMapping("/all")
    public ResponseEntity <List<CarRentalModel>> getAll(){
        List <CarRentalModel> allCarRentals = service.findAll();
        return new ResponseEntity<>(allCarRentals, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    //METODO BY ID
    //LINK: https://localhost/8080/carrental/{id}
    public ResponseEntity <?> getById(@PathVariable Long id){
        Optional<CarRentalModel> optionalCarRental = service.findById(id);

        if (optionalCarRental.isPresent()){
            return ResponseEntity.ok(optionalCarRental.get());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("id não encontrado");
        }

    }

    //METODO DELETE
    //LINK: https://localhost/8080/carrental/delete/{id}
    @DeleteMapping("/delete/{id}")
    public void deleteCarRental(@PathVariable Long id) {
        service.deleteById(id);
    }

    //METODO UPDATE
    //LINK: https://localhost/8080/carrental/UPDATE/{id}
    @PutMapping("/update/{id}")
    public ResponseEntity <?> updateCarRental(@RequestBody CarRentalModel carRental, @PathVariable Long id){

        try {
            CarRentalModel carRentalUpdate = service.update(carRental, id);
            return new ResponseEntity<>(carRentalUpdate, HttpStatus.OK);
        } catch (RuntimeException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("id nao encontrado");
        }
    }


}
