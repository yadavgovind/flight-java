package com.flight.reservation.flightreservation.repositoryimpl;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import  com.flight.reservation.flightreservation.model.UserDetails;

import com.flight.reservation.flightreservation.repository.UserRepository;

@Component
public class JwtUserDetailsService implements UserDetailsService {

    @Autowired
    private  UserRepository userRepository;

    @Autowired
    private PasswordEncoder bcryptEncoder;

    @Override
    public org.springframework.security.core.userdetails.UserDetails loadUserByUsername(final String username) throws UsernameNotFoundException {
         UserDetails userDetails = this.userRepository.findByUsername(username);
        if (userDetails!=null) {
            return new User(userDetails.getUsername(),userDetails.getPassword(),
                            new ArrayList<>());
            //            return new User("govind","$2a$10$4bWwmQQMlSkExK2P1SMZZe5dmOdcTQK9UUFdRWxVvcSmgerD5NfuW",
            //                            new ArrayList<>());

        } else {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }
    }

    public UserDetails save(final UserDetails user) {
        final UserDetails newUser = new UserDetails();
        newUser.setUsername(user.getUsername());
        newUser.setEmail(user.getEmail());
        newUser.setPassword(this.bcryptEncoder.encode(user.getPassword()));
        return this.userRepository.save(newUser);
    }

}