package com.example.springdemo2.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CustomerControler {
    private final CustomerService customerService;

    @Autowired
    public CustomerControler(CustomerService customerService) {
        this.customerService = customerService;
    }


    @GetMapping
    List<Customer> getCusomer() {
        return customerService.getCusomer();
    }
}
