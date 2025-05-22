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
    public ClientModel update(Long id, ClientModel client){
        Optional <ClientModel> oldClient = repository.findById(id);

        if (oldClient.isPresent()){
            ClientModel newClient = oldClient.get();
            newClient.setName(client.getName());
            newClient.setAddress(client.getAddress());
            newClient.setEmail(client.getEmail());

            return repository.save(client);
        } else {
            throw new RuntimeException("Id nao encontrado");
        }
    }


}
