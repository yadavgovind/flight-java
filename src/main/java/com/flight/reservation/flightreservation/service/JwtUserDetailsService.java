package com.flight.reservation.flightreservation.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

import com.flight.reservation.flightreservation.model.UserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.flight.reservation.flightreservation.model.UserDetails;
import com.flight.reservation.flightreservation.repository.UserRepository;

@Component
public class JwtUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Autowired(
        required = true)
    private PasswordEncoder bcryptEncoder;

    @Override
    public org.springframework.security.core.userdetails.UserDetails loadUserByUsername(final String username) throws UsernameNotFoundException {
        final UserDetails userDetails = this.userRepository.findByUserName(username);
        if (userDetails != null) {
            return new org.springframework.security.core.userdetails.User(userDetails.getUsername(), userDetails.getPassword(), new ArrayList<>());
            // return new User("govind","$2a$10$4bWwmQQMlSkExK2P1SMZZe5dmOdcTQK9UUFdRWxVvcSmgerD5NfuW",
            // new ArrayList<>());

        }
        else {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }
    }

    public UserDetails save(final UserDetails user) {
        user.setPassword(this.bcryptEncoder.encode(user.getPassword()));
        UserRole role=new UserRole();
        role.setRole("user");
        user.setRoles(new HashSet(Arrays.asList(role)));
        return this.userRepository.save(user);
    }
    public UserDetails getLoginUser(){
        UserDetails userDetails=null;
        String userName=null;
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (!(authentication instanceof AnonymousAuthenticationToken)) {
            userName = authentication.getName();
        }
        if(userName!=null){
            userDetails= this.userRepository.findByUserName(userName);
        }
        return userDetails;
    }

}