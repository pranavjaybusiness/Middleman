package com.middleman.authentication.controllers;


import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;


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
import com.middleman.authentication.repositories.RoleRepository;
import com.middleman.authentication.repositories.UserRepository;
import com.middleman.authentication.payloads.response.MessageResponse;
import com.middleman.authentication.models.User;
import com.middleman.authentication.models.ERole;
import com.middleman.authentication.models.Role;


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

    @Autowired
    RoleRepository roleRepository;


        @PostMapping("/signup")
        public ResponseEntity<?> registerUser(@RequestBody SignupRequest signupRequest){
            
            if(userRepository.existsByEmail(signupRequest.getEmail())){
                return ResponseEntity
                .badRequest()
                .body(new MessageResponse("Error: Email is already in use!"));
            }

            User user = new User(signupRequest.getEmail(), signupRequest.getPassword());

            Set<String> strRoles = signupRequest.getRoles();
            Set<Role> roles = new HashSet<>();

            
            if (strRoles == null) {
                Role userRole = roleRepository.findByRole(ERole.ROLE_USER)
                    .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                roles.add(userRole);
            } 
            else {
                strRoles.forEach(role -> {
                    switch (role) {
                        case "admin":
                        Role adminRole = roleRepository.findByRole(ERole.ROLE_ADMIN)
                            .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                        roles.add(adminRole);

                        break;
                        case "mod":
                        Role modRole = roleRepository.findByRole(ERole.ROLE_INTERVIEWER)
                            .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                        roles.add(modRole);

                        break;
                        default:
                        Role userRole = roleRepository.findByRole(ERole.ROLE_USER)
                            .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                        roles.add(userRole);
                    }
                });
            }

            user.setRoles(roles);
            userRepository.save(user);

            return ResponseEntity.ok(new MessageResponse("User registered successfully!"));


    }
    
   

    
}
