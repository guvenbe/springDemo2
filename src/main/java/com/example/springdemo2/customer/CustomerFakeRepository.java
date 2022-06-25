package com.example.springdemo2.customer;

import java.util.Arrays;
import java.util.List;


public class CustomerFakeRepository implements CustomerRepo{
    @Override
    public List<Customer> getcustomers() {
        return Arrays.asList(
                new Customer(1L, "James Bond", "password123"),
                new Customer(2L, "Q", "123password")
        );
    }
}
