package com.flight.reservation.flightreservation;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.flight.reservation.flightreservation.model.Passenger;
import com.flight.reservation.flightreservation.repository.PassengerRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FlightApiTest {

	@Autowired
	private PassengerRepository  passengerRepository;
	
//	@Autowired
//	private MockMvc mockMvc;
	@Test
	private void SaveTest() {
		Passenger passenger= new Passenger();
		passenger.setFirstName("Govind");
		passengerRepository.save(passenger);
		
//		when(passengerRepository.save(Passenger.class))..
	}
	
}
