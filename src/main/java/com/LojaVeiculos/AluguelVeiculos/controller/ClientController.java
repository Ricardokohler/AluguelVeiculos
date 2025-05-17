package com.LojaVeiculos.AluguelVeiculos.controller;

import com.LojaVeiculos.AluguelVeiculos.model.ClientModel;
import com.LojaVeiculos.AluguelVeiculos.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/client")
public class ClientController {

    @Autowired
    private ClientService service;

    @PostMapping
    public ClientModel createClient(@RequestBody ClientModel client){
        return service.createClient(client);
    }

    @GetMapping
    public List <ClientModel> getAllClients(){
        return service.getAllClients();
    }

    @GetMapping("/{id}")
    public Optional <ClientModel> getClientById(@PathVariable Long id){
        return service.getClientById(id);
    }

    //faltando update
    //usar put

}
