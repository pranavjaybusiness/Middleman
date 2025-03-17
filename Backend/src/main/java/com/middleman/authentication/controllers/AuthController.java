package com.middleman.authentication.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.middleman.authentication.payloads.request.SignupRequest;
import com.middleman.authentication.repositories.UserRepository;
import com.middleman.authentication.payloads.response.MessageResponse;


@CrossOrigin (origins = "*", maxAge = 3600) // right now accept CORS from anywhere
@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    AuthenticationManager authenticationManager;
    
    @Autowired 
    PasswordEncoder passwordEncoder;

    @Autowired 
    UserRepository userRepository;


    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@RequestBody SignupRequest signupRequest){
        
        if(userRepository.existsByEmail(signupRequest.getEmail())){
            return ResponseEntity
            .badRequest()
            .body(new MessageResponse("Error: Email is already in use!"));
        }



    }
    
   

    
}
