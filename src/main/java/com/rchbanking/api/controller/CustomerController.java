package com.rchbanking.api.controller;

import com.rchbanking.api.model.Customer;
import com.rchbanking.api.service.CustomerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("api/customer")
@RestController
@CrossOrigin(origins = {"http://localhost:4200"})
public class CustomerController {
    @Autowired
    private CustomerService customerService;



    @PostMapping("/register")
    public ResponseEntity<Customer> addCustomer(@RequestBody Customer customer) {
        Customer addedCustomer = customerService.addCustomer(customer);
        return new ResponseEntity<>(addedCustomer, HttpStatus.CREATED);
    }
    @GetMapping("/all")
    public ResponseEntity<List<Customer>> getAllCustomers() {
        List<Customer> customers = customerService.getAllCustomers();
        return new ResponseEntity<>(customers, HttpStatus.OK);
    }

}
