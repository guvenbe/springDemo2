package com.example.springdemo2.customer;

import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    Customer getCusomer(){
        return new Customer(1L, "James Bond");
    }

}
