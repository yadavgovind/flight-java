package com.flight.reservation.flightreservation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
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

//@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping("/flight")
public class FlightSearchController { 
	@Autowired
	private FlightRepository flightRepository;
	
	@Autowired
	private CityRepository  cityRepository;
	
	@PostMapping(value="/getFlights")
	public FlightSearchDto getFlights(@RequestBody FlightFilter flightFilter) throws Exception
	{
//		FlightFilter flightFilter = new FlightFilter();	
//		flightFilter.setArrivalCity(1);
//		flightFilter.setDeparturecity(2);
//		flightFilter.setStartDate("2019-11-12");
//		flightFilter.setStartDate("2019-11-20");
		List<Flight> arivalFlights = flightRepository.findAll(flightFilter);
		FlightSearchDto flightSearchDto=new FlightSearchDto();
		 
		flightSearchDto.setArrivalFlightList(  arivalFlights);
		return flightSearchDto;
		
	}
	

	@GetMapping(value="/cities")
	public List<City> findAll(){
		return cityRepository.findAll();
	}
}
