package com.flight.reservation.flightreservation.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.flight.reservation.flightreservation.dto.PassegerDto;
import com.flight.reservation.flightreservation.repository.ReservationRepository;
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
    @Autowired
    private ReservationRepository reservationRepository;
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
    @PostMapping(
            value = "/changeSeat")
    private Map<String,String> changeSeat(@RequestBody PassegerDto passegerDto) {
        Map<String,String> map=new HashMap<>();
        Passenger  p = passengerRepository.getPassengerBySeatNo(passegerDto.getFlightId(),passegerDto.getSeatNo(),passegerDto.getType());
        if(p==null){
            reservationRepository.changeSeat(passegerDto);
            map.put("status", "Seat Successfully booked.");
        }else
            map.put("status",  "Seat is already booked.");
        return map;
    }
}
