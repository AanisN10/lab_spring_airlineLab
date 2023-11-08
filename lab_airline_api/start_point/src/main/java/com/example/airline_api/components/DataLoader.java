package com.example.airline_api.components;

import com.example.airline_api.models.Flight;
import com.example.airline_api.models.Passenger;
import com.example.airline_api.repositories.FlightRepository;
import com.example.airline_api.repositories.PassengerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {


    @Autowired
    FlightRepository flightRepository;
    @Autowired
    PassengerRepository passengerRepository;

    public DataLoader() {

    }


    @Override
    public void run(ApplicationArguments args) throws Exception {

//         Passengers
        Passenger aanis = new Passenger("Aanis", "Aanisn10@gmail.com");
        passengerRepository.save(aanis);

        Passenger davidAttenborough = new Passenger("David attenborough", "natureman@gmail.com");
        passengerRepository.save(davidAttenborough);

        Passenger ronaldinho = new Passenger("Ronaldinho", "R10@gmail.com");
        passengerRepository.save(ronaldinho);

        Passenger messi = new Passenger("messi", "thegoat@gmail.com");
        passengerRepository.save(messi);

        Passenger lebron = new Passenger("lebron", "lebronjames6@gmail.com");
        passengerRepository.save(lebron);

        Passenger the_rock = new Passenger("Rock", "wwe@superstar.com");
        passengerRepository.save(the_rock);


//        flights

        Flight flightAlpha = new Flight(
                "New york",
                200,
                "15-12-2023",
                "08:00AM");
        flightAlpha.addPassenger(messi);
        flightAlpha.addPassenger(aanis);
        flightRepository.save(flightAlpha);
        Flight flightBeta = new Flight(
                "Los Angeles",
                20,
                "16-12-2023",
                "09:00AM");
        flightBeta.addPassenger(ronaldinho);
        flightRepository.save(flightBeta);
        Flight flightGamma = new Flight(
                "Miami",
                30,
                "17-12-2023",
                "10:00AM");
        flightGamma.addPassenger(lebron);
        flightGamma.addPassenger(the_rock);
        flightRepository.save(flightGamma);

        Flight bA4608 = new Flight(
                "Tokyo",
                100,
                "20-12-2023",
                "08:00PM");
        bA4608.addPassenger(davidAttenborough);
        flightRepository.save(bA4608);

































    }
}
