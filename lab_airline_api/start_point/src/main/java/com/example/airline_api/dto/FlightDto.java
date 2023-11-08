package com.example.airline_api.dto;

import java.util.List;

public class FlightDto {


    private Long passengerIds;


    public FlightDto(Long passengerIds) {
        this.passengerIds = passengerIds;
    }

    public FlightDto(){

    }


    public Long getPassengerIds() {
        return passengerIds;
    }

    public void setPassengerIds(Long passengerIds) {
        this.passengerIds = passengerIds;
    }
}