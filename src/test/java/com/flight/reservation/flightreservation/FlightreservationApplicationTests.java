package com.flight.reservation.flightreservation;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
//import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.flight.reservation.flightreservation.service.EmailService;

@RunWith(SpringRunner.class)
@SpringBootTest
class FlightreservationApplicationTests {
	@Autowired
	private EmailService service;
	@Test
	void testEmail() {
		service.sendEmail();
	}

}
