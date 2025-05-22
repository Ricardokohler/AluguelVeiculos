package com.LojaVeiculos.AluguelVeiculos.controller;

import com.LojaVeiculos.AluguelVeiculos.model.ClientModel;
import com.LojaVeiculos.AluguelVeiculos.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/client")
public class ClientController {

    @Autowired
    private ClientService service;

    //METODO POST
    //LINK: https://localhost/8080/client/add
    @PostMapping("/add")
    public ResponseEntity <ClientModel> createClient(@RequestBody ClientModel client){
        ClientModel newClient = service.createClient(client);
        return new ResponseEntity<>(newClient, HttpStatus.CREATED);
    }

    //METODO GET ALL
    //LINK: https://localhost/8080/client/all
    @GetMapping("/all")
    public ResponseEntity <List <ClientModel>> getAllClients(){
        List <ClientModel> allClients = service.getAllClients();
        return new ResponseEntity<>(allClients, HttpStatus.OK);
    }

    //METODO GET BY ID
    //LINK: https://localhost/8080/client/{id}
    @GetMapping("/{id}")
    public  ResponseEntity <?> getClientById(@PathVariable Long id){
        Optional <ClientModel> optionalClient = service.getClientById(id);

        if (optionalClient.isPresent()){

            return ResponseEntity.ok(optionalClient.get());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("id na encontrado");
        }

    }

    //METODO DELETE
    //LINK: https://localhost/8080/client/delete/{id}
    @DeleteMapping("/delete/{id}")
    public void deleteClientById(@PathVariable Long id){
        service.deleteClient(id);
    }

    //METODO UPDATE
    //LINK: https://localhost/8080/client/update/{id}
    @PutMapping("/update/{id}")
    public ResponseEntity <?> updateClient(@RequestBody ClientModel client, @PathVariable Long id){

        try{
            ClientModel clientUpdate = service.update(id, client);
            return new ResponseEntity<>(clientUpdate, HttpStatus.OK);

        } catch (RuntimeException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("id não encontrado");
        }
    }

}
