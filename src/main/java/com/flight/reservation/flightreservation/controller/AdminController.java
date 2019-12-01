package com.flight.reservation.flightreservation.controller;

import com.flight.reservation.flightreservation.model.Passenger;
import com.flight.reservation.flightreservation.model.Reservation;
import com.flight.reservation.flightreservation.repository.PassengerRepository;
import com.flight.reservation.flightreservation.repository.ReservationRepository;
import com.flight.reservation.flightreservation.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
public class AdminController {

    @Autowired
    private ReservationRepository reservationRepository;

    @Autowired
    private PassengerRepository passengerRepository;
    @GetMapping("/passengers/{pnr}")
    public Map<String,Object> getPassengerByPnr(@PathVariable String pnr){
        Reservation reservation= this.reservationRepository.getReservationByPnrNo(pnr);
        Map<String,Object> res=new HashMap<>();
        res.put("pessengers",passengerRepository.getPassengerByReservation(reservation.getId()));
        List<Integer> bookedSeat= passengerRepository.getPassengerByFlight(reservation.getFlight().getId(),reservation.getType()).stream().map(p->p.getSeatNo()).collect(Collectors.toList());
        res.put("seats",bookedSeat);
        return res;

    }
}
