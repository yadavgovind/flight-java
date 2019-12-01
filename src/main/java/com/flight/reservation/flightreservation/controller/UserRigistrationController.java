package com.flight.reservation.flightreservation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.flight.reservation.flightreservation.model.UserDetails;
import com.flight.reservation.flightreservation.repository.UserRepository;
import com.flight.reservation.flightreservation.service.JwtUserDetailsService;


@RestController
public class UserRigistrationController {
    @Autowired
    private JwtUserDetailsService jwtUserDetailsService;
    @Autowired
    private UserRepository userRepository;
    @GetMapping("/open/user")
    public String users(){
        return "sandeep";
    }
    @PostMapping("/open/user")
    public void createUser(@RequestBody final UserDetails user) {
        this.jwtUserDetailsService.save(user);
    }
    @GetMapping("/me")
    public UserDetails getUser() {
        return this.jwtUserDetailsService.getLoginUser();
    }
   /* @RequestMapping(
        value = "/verifyUser",
        produces = "application/json",
        consumes = "application/json",
        method = RequestMethod.POST)
    public UserDetails verifyUser(@RequestBody final UserDetails user) {
        UserDetails userDetails = new UserDetails();
        try {
            userDetails = this.userRepository.findByEmail(user.getEmail());
            // System.out.println(userDetails.getEmail()+"<--email, return userDetails.getUserName:"+userDetails.getUserName());

        }
        catch (final Error er) {
            System.out.println(er);
        }
        // System.out.println("userDetails:"+userDetails.toString());
        return userDetails;
    }
*/}
