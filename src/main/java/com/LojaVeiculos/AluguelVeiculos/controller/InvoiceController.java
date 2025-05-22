package com.LojaVeiculos.AluguelVeiculos.controller;

import com.LojaVeiculos.AluguelVeiculos.model.InvoiceModel;
import com.LojaVeiculos.AluguelVeiculos.service.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/invoice")
public class InvoiceController {

    @Autowired
    private InvoiceService service;

    //METODO POST sera feito diretamente pelo carRental para evitar fatura sem aluguel atrelado


    //METODO GET ALL
    //LINK: https://localhost/8080/invoice/all
    @GetMapping("/all")
    public ResponseEntity <List<InvoiceModel>> getAll(){
        List <InvoiceModel> allInvoices = service.getAllInvoices();
        return new ResponseEntity<>(allInvoices, HttpStatus.OK);
    }

    //METODO GET ONE
    //LINK: https://localhost/8080/invoice/{id}
    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id){
        Optional<InvoiceModel> optionalInvoice = service.getById(id);

                if(optionalInvoice.isPresent()){
                    return ResponseEntity.ok(optionalInvoice.get());

                } else {
                    return ResponseEntity.status(HttpStatus.NOT_FOUND)
                            .body("Id invalido");
                }
    }

    //METODO DELETE
    //LINK: https://localhost/8080/invoice/delete/{id}
    @DeleteMapping("delete/{id}")
    public void deleteInvoice(@PathVariable Long id){
        service.deleteById(id);
    }

    //METODO UPDATE
    //LINK: https://localhost/8080/invoice/update/{id}
    @PutMapping("/update/{id}")
    public ResponseEntity <InvoiceModel> updateInvoice(@RequestBody InvoiceModel invoice, @PathVariable Long id){

        try{
            InvoiceModel invoiceUpdate = service.updateInvoice(id, invoice);
            return new ResponseEntity<>(invoiceUpdate, HttpStatus.OK);

        } catch (RuntimeException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }
}
