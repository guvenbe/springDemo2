package com.example.springdemo2.customer;

import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;
@Component
public class CustomerRepository implements CustomerRepo {
    @Override
    public List<Customer> getcustomers() {
        //TODO conect to real db
        return Collections.emptyList();
    }
}
