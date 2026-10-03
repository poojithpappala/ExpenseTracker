package com.example.expense_tracker.services;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.expense_tracker.repository.UserRepository;

@Service 
public class CustomUserDetailsService implements UserDetailsService{
    private final UserRepository userRepository;

    public CustomUserDetailsService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    //we are returning User details, that means returning an interface tells java that we are returning an object which is implementing that interface
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException{
        return userRepository.findbyEmail(email)
                             .orElseThrow(() -> new UsernameNotFoundException("User Not found with email -> " + email));
    }
}
