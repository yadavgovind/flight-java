package com.flight.reservation.flightreservation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.flight.reservation.flightreservation.model.UserDetails;
import com.flight.reservation.flightreservation.repository.UserRepository;
import com.flight.reservation.flightreservation.service.UserRegistrationImpl;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping("/user")
public class UserRigistrationController {
	@Autowired
	private UserRepository userRepository;
	UserRegistrationImpl userRepository2=new UserRegistrationImpl();
	@RequestMapping(value = "/adduser", produces = "application/json", consumes = "application/json", method = RequestMethod.POST)
	public void  createUser(@RequestBody UserDetails user) {
		userRepository2.saveDetails(user);
		
	}
	@RequestMapping(value = "/getUser", produces = "application/json", consumes = "application/json", method = RequestMethod.POST)
	public void  getUser(@RequestBody UserDetails user ) {
		userRepository.save(user);
		
	}

	@RequestMapping(value = "/verifyUser", produces = "application/json", consumes = "application/json", method = RequestMethod.POST)
	public UserDetails  verifyUser(@RequestBody UserDetails user) { 
		UserDetails userDetails = new UserDetails();
		try {
			userDetails = userRepository.findByEmail(user.getEmail());
			//System.out.println(userDetails.getEmail()+"<--email, return userDetails.getUserName:"+userDetails.getUserName());
			
		}catch(Error er) {
			System.out.println(er);
		}
		//System.out.println("userDetails:"+userDetails.toString());
		return userDetails;
	}
	
}
