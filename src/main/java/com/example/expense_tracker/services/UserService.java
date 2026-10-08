package com.example.expense_tracker.services;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.expense_tracker.dto.RegisterRequest;
import com.example.expense_tracker.entity.User;
import com.example.expense_tracker.repository.UserRepository;

@Service 
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    
    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder){
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public String registerUser(RegisterRequest request){
        //validate the input by checking if the email already exists in the db
        if(userRepository.findByEmail(request.getEmail()).isPresent()){
            throw new RuntimeException("Email is already Registered!");
        }

        User user = new User();
        user.setEmail(request.getEmail());

        //Hash the password before saving it to the database
        user.setPassword(passwordEncoder.encode(request.getPassword()));

        user.setRole(request.getRole() != null ? request.getRole() : "ROLE_USER");

        userRepository.save(user);
        return "User Registered Successfully!";
    }
}
