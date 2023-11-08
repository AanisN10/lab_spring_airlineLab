package com.example.airline_api.services;

import com.example.airline_api.models.Passenger;
import com.example.airline_api.repositories.PassengerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PassengerService {

    @Autowired
    PassengerRepository passengerRepository;

//  find
    public List<Passenger> findAllPassengers(){
        return  passengerRepository.findAll();
    }
// save
    public void addNewPassenger(Passenger passenger){
        passengerRepository.save(passenger);
    }

//    find by id
    public Passenger findPassenger(Long id){
        return passengerRepository.findById(id).get();
    }


}
