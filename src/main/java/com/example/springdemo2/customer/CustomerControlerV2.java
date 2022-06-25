package com.example.springdemo2.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping(path = "api/v2/customer")
public class CustomerControlerV2 {
    private final CustomerService customerService;

    @Autowired
    public CustomerControlerV2(CustomerService customerService) {
        this.customerService = customerService;
    }


    @GetMapping(value = "all")
    List<Customer> getCusomer() {
        return Collections.singletonList(
                new Customer(0L, "v2", "v2")
        );
    }

    @PostMapping
    void createNewCustomer(@RequestBody Customer customer){
        System.out.println("POST REQUEST....");
        System.out.println(customer);
    }

    @PutMapping
    void updateCustomer(@RequestBody Customer customer){
        System.out.println("UPDATE PUT REQUEST....");
        System.out.println(customer);
    }
    @DeleteMapping(path = "{customerId}")
    void deleteCustomer(@PathVariable("customerId") Long id){
        System.out.println("DELETE REQUEST FOR CUSTOMER WITH ID...." + id);
    }
}
