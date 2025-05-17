package com.LojaVeiculos.AluguelVeiculos.service;

import com.LojaVeiculos.AluguelVeiculos.model.ClientModel;
import com.LojaVeiculos.AluguelVeiculos.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

    @Autowired
    private ClientRepository repository;

    //Create
    public ClientModel createClient(ClientModel client){
        return repository.save(client);
    }

    //GetAll
    public List<ClientModel> getAllClients(){
        return repository.findAll();
    }

    //GetById
    public Optional<ClientModel> getClientById(Long id){
        return repository.findById(id);
    }

    //Delete
    public void deleteClient(Long id){
        repository.deleteById(id);
    }

    //Update
    //metodo update aqui


}
