package com.flight.reservation.flightreservation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

@SpringBootApplication
public class FlightreservationApplication implements CommandLineRunner {
	
	@Autowired
	private JavaMailSender javaMailSender;

	public static void main(String[] args) {
		SpringApplication.run(FlightreservationApplication.class, args);
	}

	@Override
	public void run(String... args) {

		System.out.println("Sending Email...");

		try {

			sendEmail();
			// sendEmailWithAttachment();

		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println("Done");

	}

	public void sendEmail() {

		SimpleMailMessage msg = new SimpleMailMessage();
		msg.setTo("alluru.nagaraju@gmail.com");

		msg.setSubject("Testing from Spring Boot");
		msg.setText("Hello WorldSpring Boot Email");

		javaMailSender.send(msg);

	}

}
