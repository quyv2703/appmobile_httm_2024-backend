package com.ltq27.Baotrimaylanh.controller;

import com.ltq27.Baotrimaylanh.dto.request.customer.CustomerDTO;
import com.ltq27.Baotrimaylanh.entity.Customer;
import com.ltq27.Baotrimaylanh.service.CustomerSerVice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {
    @Autowired
    private CustomerSerVice customerService;

    @GetMapping("/id")
    public ResponseEntity<Long> getCustomerIdByUsername(@RequestParam String username) {
        Long customerId = customerService.getCustomerIdByUsername(username);
        if (customerId != null) {
            return ResponseEntity.ok(customerId);
        } else {
            return ResponseEntity.status(404).build(); // Not Found
        }
    }
    @GetMapping("/username/{username}")
    public ResponseEntity<CustomerDTO> getCustomerByUsername(@PathVariable String username) {
        CustomerDTO customerDTO = customerService.getCustomerByUsername(username);
        if (customerDTO == null) {
            return ResponseEntity.status(404).build();
        }
        return ResponseEntity.ok(customerDTO);
    }
}