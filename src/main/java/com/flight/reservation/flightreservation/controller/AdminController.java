package com.flight.reservation.flightreservation.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.flight.reservation.flightreservation.model.FlightShedule;
import com.flight.reservation.flightreservation.model.Passenger;
import com.flight.reservation.flightreservation.model.Reservation;
import com.flight.reservation.flightreservation.repository.FlightSheduleRepository;
import com.flight.reservation.flightreservation.repository.PassengerRepository;
import com.flight.reservation.flightreservation.repository.ReservationRepository;

@RestController
public class AdminController {

    @Autowired
    private ReservationRepository reservationRepository;

    @Autowired
    private PassengerRepository passengerRepository;
    @Autowired
    private FlightSheduleRepository flightSheduleRepository;

    @Autowired
    private JavaMailSender javaMailSender;

    @GetMapping("/passengers/{pnr}")
    public Map<String, Object> getPassengerByPnr(@PathVariable final String pnr) {
        final Reservation reservation = this.reservationRepository.getReservationByPnrNo(pnr);
        final Map<String, Object> res = new HashMap<>();
        res.put("pessengers", this.passengerRepository.getPassengerByReservation(reservation.getId()));
        final List<Integer> bookedSeat = this.passengerRepository.getPassengerByFlight(reservation.getFlight()
            .getId(), reservation.getType())
            .stream()
            .map(p -> p.getSeatNo())
            .collect(Collectors.toList());
        res.put("seats", bookedSeat);
        return res;

    }

    @PostMapping("/cancelFlight")
    public void cancelFlight(@RequestBody final FlightShedule flightShedule) {
        final List<Passenger> passengers = this.passengerRepository.getPassengerByFlightId(flightShedule.getFlightId());
        this.flightSheduleRepository.save(flightShedule);
        passengers.forEach(passenger -> {

            final SimpleMailMessage msg = new SimpleMailMessage();
            msg.setFrom("aishwarya.asp9@gmail.com");
            msg.setTo(passenger.getEmail());
            msg.setSubject("reservation cancelled");
            msg.setText(passenger.getReservation()
                .getPnrNo() + " pnr no reservation cancelled");
            this.javaMailSender.send(msg);
        });

    }
}
