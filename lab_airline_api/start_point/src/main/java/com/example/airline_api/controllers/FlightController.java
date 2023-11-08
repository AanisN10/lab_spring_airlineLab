package com.example.airline_api.controllers;

import com.example.airline_api.dto.FlightDto;
import com.example.airline_api.models.Flight;
import com.example.airline_api.models.Passenger;
import com.example.airline_api.repositories.FlightRepository;
import com.example.airline_api.services.FlightService;
import com.example.airline_api.services.PassengerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/flights")
public class FlightController {

    @Autowired
    FlightService flightService;
    @Autowired
    PassengerService passengerService;

//     Display all available flights
    @GetMapping
    public ResponseEntity<List<Flight>> getAllFlights(){
        List<Flight> allFlights = flightService.getAllFlights();
        return new ResponseEntity<>(allFlights, HttpStatus.OK);
    }

//    // Display a specific flight
    @GetMapping(value = "/{id}")
    public ResponseEntity<Optional<Flight>> getFlightById(@PathVariable Long id){
        Optional<Flight> flight = flightService.getFlightById(id);
        if(flight.isPresent()){
            return new ResponseEntity<>(flight,HttpStatus.OK);
        }else{
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }

    }

//     Add details of a new flight

    @PostMapping
    public ResponseEntity<Flight> saveFlight(@PathVariable Flight flight){
        flightService.saveFlight(flight);
        return new ResponseEntity<>(flight, HttpStatus.CREATED);
    }

    // Book passenger on a flight
    @PatchMapping(value = "/{id}")
    public ResponseEntity<Flight> addPassengerToFlight(
            @RequestBody FlightDto flightDto,
            @PathVariable Long id){
        Flight addPassenger = flightService.addPassengerToFlight(flightDto,id);
        return new ResponseEntity<>(addPassenger,HttpStatus.OK);

        }


    // Cancel flight
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Flight> cancelFlight(@PathVariable Long id){
        flightService.deleteFlight(id);
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

}
