package com.flight.reservation.flightreservation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.flight.reservation.flightreservation.model.Passenger;
import com.flight.reservation.flightreservation.repository.PassengerRepository;

@RestController
// @RequestMapping("/api")
public class PassengerController {

    @Autowired
    private PassengerRepository passengerRepository;

    @GetMapping(
        value = "/passengers")
    public List<Passenger> findAll() {
        return this.passengerRepository.findAll();
    }

    @PostMapping(
        value = "/passenger")
    public void create(@RequestBody final Passenger entity) {
        this.passengerRepository.save(entity);
    }
}
