package com.rchbanking.api.controller;

import com.rchbanking.api.model.Customer;
import com.rchbanking.api.service.CustomerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("api/customer")
@RestController
public class CustomerController {
    @Autowired
    private CustomerService customerService;



    @PostMapping("/register")
    ResponseEntity<Customer> addCustomer(@RequestBody Customer customer) {
        Customer addedCustomer = customerService.addCustomer(customer);
        return new ResponseEntity<>(addedCustomer, HttpStatus.CREATED);
    }

}
