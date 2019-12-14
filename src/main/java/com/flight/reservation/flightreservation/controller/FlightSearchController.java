package com.flight.reservation.flightreservation.controller;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.apache.logging.log4j.message.AsynchronouslyFormattable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.flight.reservation.flightreservation.dto.FlightSearchDto;
import com.flight.reservation.flightreservation.filter.FlightFilter;
import com.flight.reservation.flightreservation.model.City;
import com.flight.reservation.flightreservation.model.Flight;
import com.flight.reservation.flightreservation.model.FlightShedule;
import com.flight.reservation.flightreservation.repository.CityRepository;
import com.flight.reservation.flightreservation.repository.FlightRepository;
import com.flight.reservation.flightreservation.repository.FlightSheduleRepository;

import ch.qos.logback.core.net.SyslogOutputStream;

@RestController
@RequestMapping("/flight")
public class FlightSearchController {
	@Autowired
	private FlightRepository flightRepository;

	@Autowired
	private FlightSheduleRepository flightSheduleRepository;
	@Autowired
	private CityRepository cityRepository;

	@PostMapping(value = "/getFlights")
	public FlightSearchDto getFlights(@RequestBody final FlightFilter flightFilter) throws Exception {
		//get cancelled flights
		List<FlightShedule> cancelFlights = flightSheduleRepository.findAll();
		
		final List<Flight> arivalFlights = this.flightRepository.findAll(flightFilter, false);
		final FlightSearchDto flightSearchDto = new FlightSearchDto();
		Predicate<Flight> pridicateOneWay = flight -> cancelFlights.stream()
				.filter(cancelFlight -> cancelFlight.getFlightId() == flight.getId()
						&& cancelFlight.getTravelDate().equals(flightFilter.getTravellDate()))
				.findAny().isPresent();
		arivalFlights.removeIf(pridicateOneWay::test);

		flightSearchDto.setArrivalFlightList(arivalFlights);
		if (flightFilter.getReturnDate() != null) {
			final List<Flight> returnFlights = this.flightRepository.findAll(flightFilter, true);
			Predicate<Flight> pridicateTwoWay = flight -> cancelFlights.stream()
					.filter(cancelFlight -> cancelFlight.getFlightId() == flight.getId()
							&& cancelFlight.getTravelDate() == flightFilter.getReturnDate())
					.findAny().isPresent();
			returnFlights.removeIf(pridicateTwoWay::test);
			flightSearchDto.setDepartFlightList(returnFlights);
		}

		return flightSearchDto;

	}

	@GetMapping(value = "/fights")
	public List<Flight> findAllFlight() {
		return this.flightRepository.findAll();
	}

	@GetMapping(value = "/cities")
	public List<City> findAll() {
		return this.cityRepository.findAll();
	}

	@Async
	@GetMapping(value = "/citiesWithAshync")
	public CompletableFuture<List<City>> findAllAsync() {
		List<City> findAll = this.cityRepository.findAll();

		System.out.print(Thread.currentThread().getName());

		return CompletableFuture.completedFuture(findAll);
	}

}
