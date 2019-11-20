package com.flight.reservation.flightreservation.controller;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.flight.reservation.flightreservation.dto.FlightSearchDto;
import com.flight.reservation.flightreservation.model.Flight;
import com.flight.reservation.flightreservation.repository.FlightRepository;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping("/flight")
public class FlightSearchController {
	@Autowired
	private FlightRepository flightRepository;
	@RequestMapping("/getFlights")
	public FlightSearchDto getFlights(Flight flightDto ) throws Exception
	{
		List<Flight> departlist= flightRepository.findFlights(flightDto.getDepartureCity(), flightDto.getArrivalCity());
		List<Flight> returnlist= flightRepository.findFlights(flightDto.getArrivalCity(),flightDto.getDepartureCity());
		FlightSearchDto flightSearchDto=new FlightSearchDto();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		List<Flight> departFlightInfo=new ArrayList<Flight>();
		List<Flight> arrivalFlightInfo=new ArrayList<Flight>();
		Date searchDateDepart =(Date)formatter.parse(flightDto.getDateOfDeparture());
		Date searchDateReturn =(Date)formatter.parse(flightDto.getDateOfReturn());
		
		for(Flight flight :departlist){
			if(null!=flight.getDateOfDeparture()){
			Date departDate=(Date) formatter.parse(flight.getDateOfDeparture());
			if(departDate.compareTo(searchDateDepart)==0){
				departFlightInfo.add(flight);
			}
			}
		}
		for(Flight flight :returnlist){
			if(null!=flight.getDateOfReturn()){
			Date returnDate=(Date) formatter.parse(flight.getDateOfReturn());
			if(returnDate.compareTo(searchDateReturn)==0){
				arrivalFlightInfo.add(flight);
			}
			}
		}
		flightSearchDto.setArrivalFlightList(departFlightInfo);
		flightSearchDto.setDepartFlightList(arrivalFlightInfo);
		return flightSearchDto;
		
	}
	

}
