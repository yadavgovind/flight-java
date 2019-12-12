package com.flight.reservation.flightreservation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;

import com.flight.reservation.flightreservation.service.EmailService;

@SpringBootApplication
public class FlightreservationApplication  {
	
	@Autowired
    public Environment env;
	public static void main(String[] args) {
		SpringApplication.run(FlightreservationApplication.class, args);
	}
	@Bean
	public EmailService emailService() {
		EmailService emailService=new EmailService(env.getProperty("email.from"), env.getProperty("email.api"));
		return emailService;
	}
}