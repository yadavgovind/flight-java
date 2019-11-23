package com.flight.reservation.flightreservation.controller;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.flight.reservation.flightreservation.dto.FlightSearchDto;
import com.flight.reservation.flightreservation.filter.FlightFilter;
import com.flight.reservation.flightreservation.model.City;
import com.flight.reservation.flightreservation.model.Flight;
import com.flight.reservation.flightreservation.repository.CityRepository;
import com.flight.reservation.flightreservation.repository.FlightRepository;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping("/flight")
public class FlightSearchController { 
	@Autowired
	private FlightRepository flightRepository;
	
	@Autowired
	private CityRepository  cityRepository;
	
	@RequestMapping("/getFlights")
	public FlightSearchDto getFlights() throws Exception
	{
		
		List<Flight> arivalFlights = flightRepository.findAll(new FlightFilter());
		FlightSearchDto flightSearchDto=new FlightSearchDto();
		 
		flightSearchDto.setArrivalFlightList(  arivalFlights);
		return flightSearchDto;
		
	}
	

	@GetMapping(value="/cities")
	public List<City> findAll(){
		return cityRepository.findAll();
	}
}
