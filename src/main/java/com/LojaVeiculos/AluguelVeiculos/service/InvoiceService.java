package com.LojaVeiculos.AluguelVeiculos.service;

import com.LojaVeiculos.AluguelVeiculos.model.InvoiceModel;
import com.LojaVeiculos.AluguelVeiculos.repository.InvoiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InvoiceService {


    @Autowired
    private InvoiceRepository repository;

    //createInvoice direto no crud de CarRental Para evitar problemas

    //getAll
    public List<InvoiceModel> getAllInvoices(){
        return repository.findAll();
    }

    //getOne
    public Optional<InvoiceModel> getById(Long id){
        return repository.findById(id);
    }

    //delete
    public void deleteById(Long id){
        repository.deleteById(id);
    }

    //Update
    public InvoiceModel updateInvoice(Long id,InvoiceModel invoice){
        Optional <InvoiceModel> oldInvoice = repository.findById(id);

        if(oldInvoice.isPresent()){
            InvoiceModel newInvoice = oldInvoice.get();
            newInvoice.setBasicPayment(invoice.getBasicPayment());
            newInvoice.setTax(invoice.getTax());

            return repository.save(newInvoice);

        } else {
            throw new RuntimeException ("Fatura nao encontrada! " + id + "Tente novamente");
        }

    }

}
