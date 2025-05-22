package com.LojaVeiculos.AluguelVeiculos.service;

import com.LojaVeiculos.AluguelVeiculos.model.CarRentalModel;
import com.LojaVeiculos.AluguelVeiculos.model.InvoiceModel;
import com.LojaVeiculos.AluguelVeiculos.repository.CarRentalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.util.List;
import java.util.Optional;

@Service
public class CarRentalService {

    private double pricePerHour = 100;
    private double pricePerDay = 400;

    @Autowired
    private CarRentalRepository repository;

    //create
    public CarRentalModel processInvoice(CarRentalModel carRental){
        double minutes = Duration.between(carRental.getStart(), carRental.getFinish()).toMinutes();
        double hours = minutes / 60;

        double basicPayment = pricePerHour * Math.ceil(hours);
        double tax = 1;

        //processamento do pedido:
        InvoiceModel invoice = new InvoiceModel();
        invoice.setBasicPayment(basicPayment);
        invoice.setTax(tax);
        invoice.setCarRental(carRental);

        carRental.setInvoice(invoice);

        return repository.save(carRental);
    }

    //getAll
    public List<CarRentalModel> findAll(){
        return repository.findAll();
    }

    //getOne
    public Optional <CarRentalModel> findById(Long id){
        return repository.findById(id);
    }

    //delete
    public void deleteById(Long id){
        repository.deleteById(id);
    }

    //Update
    public CarRentalModel update(CarRentalModel carRental, Long id){
        Optional <CarRentalModel> oldCarRental = repository.findById(id);

        if (oldCarRental.isPresent()){
            CarRentalModel newCarRental = oldCarRental.get();
            newCarRental.setStart(carRental.getStart());
            newCarRental.setFinish(carRental.getFinish());

            return repository.save(newCarRental);
        } else{

            throw new RuntimeException("Id não encontrado");

        }
    }

}
