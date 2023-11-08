package com.example.airline_api.services;

import com.example.airline_api.dto.FlightDto;
import com.example.airline_api.models.Flight;
import com.example.airline_api.models.Passenger;
import com.example.airline_api.repositories.FlightRepository;
import com.example.airline_api.repositories.PassengerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class FlightService {

    @Autowired
    FlightRepository flightRepository;

    @Autowired
    PassengerService passengerService;

    @Autowired
    PassengerRepository passengerRepository;


    //    find all flights
    public List<Flight> getAllFlights() {
        return flightRepository.findAll();
    }

    //    // find flights by id
    public Optional<Flight> getFlightById(long id) {
        return flightRepository.findById(id);
    }


    //      save flight and add passenger
    public Flight saveFlight(Flight flight) {
        return flightRepository.save(flight);
    }

    public Flight addPassengerToFlight(FlightDto flightDto, Long id) {
        Flight flight = flightRepository.findById(id).get();
        Passenger passenger = passengerRepository.findById(flightDto.getPassengerIds()).get();
        flight.addPassenger(passenger);
        flightRepository.save(flight);
        return flight;
    }


//    method to delete flight
    public void deleteFlight(Long id) {
        flightRepository.deleteById(id);
    }


//    method to delete flight that contains passenger
}