package com.flight.reservation.flightreservation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.flight.reservation.flightreservation.dto.FlightSearchDto;
import com.flight.reservation.flightreservation.filter.FlightFilter;
import com.flight.reservation.flightreservation.model.City;
import com.flight.reservation.flightreservation.model.Flight;
import com.flight.reservation.flightreservation.repository.CityRepository;
import com.flight.reservation.flightreservation.repository.FlightRepository;

@RestController
@RequestMapping("/flight")
public class FlightSearchController {
    @Autowired
    private FlightRepository flightRepository;

    @Autowired
    private CityRepository cityRepository;

    @PostMapping(
        value = "/getFlights")
    public FlightSearchDto getFlights(@RequestBody final FlightFilter flightFilter) throws Exception {

        final List<Flight> arivalFlights = this.flightRepository.findAll(flightFilter, false);
        final FlightSearchDto flightSearchDto = new FlightSearchDto();
        flightSearchDto.setArrivalFlightList(arivalFlights);
        if (flightFilter.getReturnDate() != null) {
            final List<Flight> returnFlights = this.flightRepository.findAll(flightFilter, true);
            flightSearchDto.setDepartFlightList(returnFlights);
        }
        return flightSearchDto;

    }

    @GetMapping(
        value = "/fights")
    public List<Flight> findAllFlight() {
        return this.flightRepository.findAll();
    }

    @GetMapping(
        value = "/cities")
    public List<City> findAll() {
        return this.cityRepository.findAll();
    }
}
