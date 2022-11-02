package com.rchbanking.api.controller;


import com.rchbanking.api.model.AuthRequest;
import com.rchbanking.api.service.AuthService;
import com.rchbanking.api.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("api/auth")
public class AuthController {

    @Autowired
    private CustomerService customerService;
    @Autowired
    private AuthService authService;

    @PostMapping("/login")
    ResponseEntity<String> login (@RequestBody AuthRequest request) {
        Optional<String> result = authService.Authenticate(request);
        if (result.isPresent()) {
            return new ResponseEntity<>(result.get(), HttpStatus.ACCEPTED);
        }
        return new ResponseEntity<>("", HttpStatus.FORBIDDEN);
    }
}

